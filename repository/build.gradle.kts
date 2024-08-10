@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.dev.carlosivis.kotlin.domain)
}

dependencies {
    implementation(projects.core.commons)
    api(projects.domain.pokemon)
    implementation(libs.koin.core)
    implementation(libs.kotlinx.coroutines.core)
}
