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
    maven { setUrl("https://jitpack.io") }
}

dependencies {
    implementation(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
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

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            pom {
                name.set("buildconfig-gradle-plugin")
                description.set("buildconfig-gradle-plugin is a version plugin")
                url.set("https://github.com/HelloVass/build-config-gradle-plugin")
                properties.set(
                    mapOf(
                        "author" to "HelloVass"
                    )
                )
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("HelloVass")
                        name.set("HelloVass")
                        email.set("hellova33@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/HelloVass/build-config-gradle-plugin.git")
                    developerConnection.set("scm:git:ssh://github.com/HelloVass/build-config-gradle-plugin.git")
                    url.set("https://github.com/HelloVass/build-config-gradle-plugin")
                }
                from(components["java"])
                artifact(sourcesJar.get())
            }
        }
    }
}