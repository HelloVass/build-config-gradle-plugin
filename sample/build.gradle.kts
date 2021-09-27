plugins {
    kotlin("jvm")
    id("info.hellovass.buildconfig_gradle_plugin")
}

buildConfigKt {
    group = "info.hellovass.buildconfig_gradle_plugin"
    name = "buildconfig_gradle_plugin"
    version = "1.0.0"
    className = "BuildConfig"
    packageName = "info.hellovass.buildconfig_gradle_plugin"
}

