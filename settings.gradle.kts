pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "Pokedex"
include(":app")
include(":repository")
include(":core:core")
include(":core:navigation")
include(":core:uikit")
include(":core:commons")
include(":data:local")
include(":data:remote")
include(":domain:pokemon")
include(":feature:main")
