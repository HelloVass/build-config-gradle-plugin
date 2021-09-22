package info.hellovass.buildconfig_gradle_plugin

import com.squareup.kotlinpoet.ClassName
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.getByType

open class GenerateBuildConfigKtTask : DefaultTask() {

    @OutputDirectory
    val output = project.file(
        BuildConfigUtils.getRootOutputPath(project.buildDir.toPath())
    )

    init {
        description = "Generates a BuildConfig.kt with build information"
    }

    @TaskAction
    fun generateBuildConfig() {

        val buildConfigExtension = project.extensions.getByType(BuildConfigExtension::class)

        val fileSpec = BuildConfigKtFileGenerator.prepareKtFile(
            className = ClassName(
                packageName = buildConfigExtension.packageName,
                simpleNames = listOf(
                    buildConfigExtension.className
                )
            ),
            properties = listOf(
                "GROUP" to buildConfigExtension.group,
                "NAME" to buildConfigExtension.name,
                "VERSION" to buildConfigExtension.version
            )
        )

        fileSpec.writeTo(output)
    }
}
