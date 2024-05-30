@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("dev.carlosivis.kotlin.domain")
}

dependencies {
    implementation(project(":core:commons"))
    api(project(":domain:pokemon"))
    implementation(libs.koin.core)
    implementation(libs.kotlinx.coroutines.core)
}