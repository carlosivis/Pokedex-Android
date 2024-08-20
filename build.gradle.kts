plugins {
    id("com.android.application") version ("8.0.1") apply false
    id("com.android.library") version ("8.0.1") apply false
    id("org.jetbrains.kotlin.android") version ("2.0.0") apply false
    id("org.jetbrains.kotlin.plugin.compose") version ("2.0.0") apply false
}

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.22.0")
    }
}