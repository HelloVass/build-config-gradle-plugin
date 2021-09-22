package info.hellovass.buildconfig_gradle_plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class BuildConfigPlugin : Plugin<Project> {

    override fun apply(target: Project) {

        Logger.getInstance(target.gradle).info("Creating buildConfigKt extension...")

        target.extensions.create<BuildConfigExtension>("buildConfigKt")

        target.afterEvaluate {

            if (plugins.hasPlugin("org.jetbrains.kotlin.jvm")) {

                Logger.getInstance(target.gradle)
                    .successHeader("Registering generateBuildConfigKt task...")

                tasks.register(
                    "generateBuildConfigKt",
                    GenerateBuildConfigKtTask::class.java
                )

                Logger.getInstance(target.gradle)
                    .info("Adding buildConfigKt generated directory to Kotlin src...")

                extensions.findByType(KotlinJvmProjectExtension::class.java)?.apply {
                    sourceSets.findByName("main")?.apply {
                        kotlin.apply {
                            srcDir(
                                BuildConfigUtils.getRootOutputPath(
                                    projectBuildDir = buildDir.toPath()
                                )
                            )
                        }
                    }
                }

                Logger.getInstance(target.gradle)
                    .info("Adding 'generateBuildConfigKt' as a dependency for Kotlin compilation tasks...")

                tasks.withType<KotlinCompile>().configureEach {
                    dependsOn("generateBuildConfigKt")
                }
            }
        }
    }
}