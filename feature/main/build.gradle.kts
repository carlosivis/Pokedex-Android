@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.dev.carlosivis.android.feature)
    id("org.jetbrains.kotlin.plugin.compose")
    id("kotlin-parcelize")
}
true

android.namespace = "dev.tavieto.hearthstone.feature.main"

dependencies {
    implementation(projects.domain.pokemon)
    implementation(platform(libs.kotlin.bom))
    implementation(libs.coil.compose)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.palette.ktx)
    implementation(libs.accompanist.placeholder)

}
