@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.dev.carlosivis.android.library)
    alias(libs.plugins.dev.carlosivis.android.compose)
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}
true

android.namespace = "dev.carlosivis.pokedex.core.navigation"

dependencies {
    implementation(projects.core.commons)
    implementation(projects.feature.main)
    api(libs.androidx.navigation)
    api(libs.androidx.navigation.common.ktx)
    implementation(libs.koin.androidx.compose)
    implementation(libs.gson)
}