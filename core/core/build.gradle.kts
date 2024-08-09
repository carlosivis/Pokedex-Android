@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("dev.carlosivis.android.library")
    id("dev.carlosivis.android.compose")
    id("kotlin-parcelize")
}
true

android.namespace = "dev.carlosivis.pokedex.core"

dependencies {
    api(project(":core:commons"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.koin.core)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.kotlinx.coroutines.core)
}