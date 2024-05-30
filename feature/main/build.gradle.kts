@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.dev.carlosivis.android.feature)
    id("kotlin-parcelize")
}
true

android.namespace = "dev.carlosivis.pokedex.feature.main"

dependencies {
    implementation(project(":domain:pokemon"))
    implementation(platform(libs.kotlin.bom))
    implementation(libs.coil.compose)
}