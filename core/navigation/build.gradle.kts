@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("dev.carlosivis.android.library")
    id("dev.carlosivis.android.compose")
}
true

android.namespace = "dev.carlosivis.pokedex.core.navigation"

dependencies {
    implementation(project(":core:commons"))
    implementation(project(":feature:main"))
    api(libs.androidx.navigation)
    api(libs.androidx.navigation.common.ktx)
    implementation(libs.koin.androidx.compose)
    implementation(libs.gson)
}