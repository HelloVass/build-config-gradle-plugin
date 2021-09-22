rootProject.name = "build-config"

include(":buildconfig-gradle-plugin",":test-lib")

buildscript {

    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }

    dependencies {
        classpath("info.hellovass.buildconfig_gradle_plugin:buildconfig-gradle-plugin:1.0.0-SNAPSHOT")
    }
}