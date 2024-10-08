@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.dev.carlosivis.android.library)
    alias(libs.plugins.dev.carlosivis.android.compose)
    id("org.jetbrains.kotlin.plugin.compose")
    id("kotlin-parcelize")
}
true

android.namespace = "dev.carlosivis.pokedex.core"

dependencies {
    api(projects.core.commons)
    implementation(libs.koin.core)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.kotlinx.coroutines.core)
}