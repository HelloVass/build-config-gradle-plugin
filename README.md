# buildconfig-gradle-plugin

[![](https://jitpack.io/v/HelloVass/build-config-gradle-plugin.svg)](https://jitpack.io/#HelloVass/build-config-gradle-plugin)

# Thanks

在翻 github 的时候看到了这个[buildconfig-gradle-plugin](https://github.com/PixelOutlaw/buildconfig-gradle-plugin)，然后看了下原理也不复杂，于是也自己手撸了一遍，顺便看看在高版本的 Gradle 会不会有啥坑。

# 使用

## 安装插件

在想要生成 BuildConfig.kt 文件的地方，编辑 build.gradle(.kts)

```kotlin
plugins {
    id("info.hellovass.buildconfig_gradle_plugin")
}
```

## 配置 BuildConfigExtension 扩展

```kotlin
// 由 kotlin-dsl 编译时生成
buildConfigKt {
    group = "info.hellovass.buildconfig_gradle_plugin"
    name = "buildconfig_gradle_plugin"
    version = "1.0.0"
    className = "BuildConfig"
    packageName = "info.hellovass.buildconfig_gradle_plugin"
}
```

## Build，生成 BuildConfig.kt

```kotlin
// build/generated/source/buildConfigKt/{包名}/BuildConfig.kt
```