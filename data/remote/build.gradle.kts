plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

android {
    namespace = "dev.carlosivis.pokedex.data.remote"
    compileSdk = 34
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {

    implementation(project(":core:commons"))
    implementation(project(":repository"))
    implementation(libs.koin.core)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.retrofit2.retrofit)
    implementation(libs.okhttp3.okhttp)
    implementation(libs.okhttp3.logging.interception)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.androidx.core.ktx)
}