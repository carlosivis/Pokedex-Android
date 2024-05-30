plugins {
    id("dev.carlosivis.android.library")
    id("kotlin-kapt")
}

android.namespace = "dev.carlosivis.pokedex.data.local"

dependencies {
    implementation(project(":core:commons"))
    implementation(project(":repository"))
    implementation(libs.koin.android)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.gson)
}