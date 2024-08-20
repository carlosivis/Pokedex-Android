package dev.carlosivis.buildlogic

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import java.util.Properties

internal fun Project.configureAndroidDefaultSettings(
    commonExtension: LibraryExtension
) {

    val secrets = Properties()
    secrets.load(this.project.rootProject.file("secrets.properties").inputStream())

    commonExtension.apply {
        compileSdk = 34
        defaultConfig {
            minSdk = 24
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables.useSupportLibrary = true
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        sourceSets {
            getByName("main").java.srcDir("src/main/kotlin")
        }

        buildFeatures {
            buildConfig = true
        }
        buildTypes {
            getByName("release") {
                isMinifyEnabled = true
                isJniDebuggable = false
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), file("proguard-rules.pro"))
            }
            getByName("debug") {
                isMinifyEnabled = false
                isJniDebuggable = true
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), file("proguard-rules.pro"))
            }
        }
        buildTypes.all {
            buildConfigField(
                type = "String",
                name = "BASE_URL",
                value = secrets.getProperty("BASE_URL")
            )
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }
}
