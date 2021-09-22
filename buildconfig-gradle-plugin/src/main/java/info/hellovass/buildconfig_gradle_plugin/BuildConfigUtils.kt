package info.hellovass.buildconfig_gradle_plugin

import java.nio.file.Path

object BuildConfigUtils {

    fun getRootOutputPath(projectBuildDir: Path): Path {
        return projectBuildDir.resolve("generated-sources/buildConfigKt")
    }
}