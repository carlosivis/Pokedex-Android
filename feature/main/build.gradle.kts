plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "dev.carlosivis.pokedex.feature.main"
    compileSdk = 34
    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.ui.tooling.preview.android)
    implementation(project(":core:uikit"))
    implementation(project(":core:core"))
    implementation(project(":domain:pokemon"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(platform(libs.kotlin.bom))
    implementation(libs.koin.android)
    implementation(libs.androidx.compose.material)
    implementation(platform(libs.androidx.compose.bom))
    implementation(platform(libs.androidx.ui.tooling.preview))
    implementation(libs.coil.compose)
    implementation(libs.kotlinx.coroutines.core)



}