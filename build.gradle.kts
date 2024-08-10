plugins {
    id("com.android.application") version ("7.4.2") apply false
    id("com.android.library") version ("7.4.2") apply false
    id("org.jetbrains.kotlin.android") version ("2.0.0") apply false
}

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("com.google.gms:google-services:4.4.1")
        classpath("com.google.firebase:firebase-crashlytics-gradle:3.0.1")
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.22.0")
    }
}