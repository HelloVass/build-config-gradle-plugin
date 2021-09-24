plugins {
    kotlin("jvm")
    id("info.hellovass.buildconfig_gradle_plugin")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.32")
}

buildConfigKt {
    group = "hellovass.info.test_lib"
    name = "test-lib"
    version = "1.0.0-SNAPSHOT"
    packageName = "hellovass.info.test_lib"
    className = "BuildConfig"
}
