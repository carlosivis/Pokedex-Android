plugins {
    `kotlin-dsl`
}

group = "dev.carlosivis.buildlogic.builder"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies{
    compileOnly("com.android.tools.build:gradle:8.0.1")
    compileOnly("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.22.0")

}
gradlePlugin {
    plugins {
        create("AndroidLibrary") {
            id = "dev.carlosivis.android.library"
            implementationClass = "AndroidLibrary"
            version = "1.0.0"
        }
        create("JetpackComposeConfig") {
            id = "dev.carlosivis.android.compose"
            implementationClass = "AndroidJetpackCompose"
            version = "1.0.0"
        }
        create("AndroidFeature") {
            id = "dev.carlosivis.android.feature"
            implementationClass = "AndroidFeatureDefaultSettings"
            version = "1.0.0"
        }
        create("KotlinDomain") {
            id = "dev.carlosivis.kotlin.domain"
            implementationClass = "KotlinDomain"
            version = "1.0.0"
        }
    }
}