@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.dev.carlosivis.android.feature)
    id("kotlin-parcelize")
}
true

android.namespace = "dev.tavieto.hearthstone.feature.main"

dependencies {
    implementation(projects.domain.pokemon)
    implementation(platform(libs.kotlin.bom))
    implementation(libs.coil.compose)
}
