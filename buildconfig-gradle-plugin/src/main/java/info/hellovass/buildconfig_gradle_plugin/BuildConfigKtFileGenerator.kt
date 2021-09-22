package info.hellovass.buildconfig_gradle_plugin

import com.squareup.kotlinpoet.*

class BuildConfigKtFileGenerator private constructor() {

    companion object {

        fun prepareKtFile(
            className: ClassName,
            properties: List<Pair<String, String>>
        ): FileSpec {

            val buildConfigBuilder = TypeSpec.objectBuilder(className)

            properties.map(::generateProperty)
                .forEach { buildConfigBuilder.addProperty(it) }

            return FileSpec.builder(className.packageName, className.simpleName)
                .addType(buildConfigBuilder.build())
                .build()
        }

        private fun generateProperty(pair: Pair<String, String>): PropertySpec {
            return PropertySpec.builder(pair.first, String::class, KModifier.CONST)
                .initializer("%S", pair.second)
                .build()
        }
    }
}


