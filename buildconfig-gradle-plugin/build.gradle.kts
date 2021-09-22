plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
}

group = "info.hellovass.buildconfig_gradle_plugin"
version = "1.0.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
    implementation("com.squareup:kotlinpoet:+") {
        exclude(group = "org.jetbrains.kotlin")
    }
}

gradlePlugin {
    plugins {
        create("buildconfig-gradle-plugin") {
            id = "info.hellovass.buildconfig_gradle_plugin"
            implementationClass = "info.hellovass.buildconfig_gradle_plugin.BuildConfigPlugin"
        }
    }
}

