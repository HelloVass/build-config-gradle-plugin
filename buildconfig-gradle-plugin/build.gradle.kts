plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    maven
}

group = "info.hellovass.buildconfig_gradle_plugin"
version = "1.0.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

dependencies {
    implementation(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
    implementation("com.squareup:kotlinpoet:1.10.1") {
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