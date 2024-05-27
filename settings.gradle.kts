pluginManagement {
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
