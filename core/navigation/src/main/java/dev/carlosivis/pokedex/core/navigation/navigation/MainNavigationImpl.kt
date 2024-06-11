package dev.carlosivis.pokedex.core.navigation.navigation

import dev.carlosivis.pokedex.core.navigation.manager.NavigationManager
import dev.carlosivis.pokedex.core.navigation.routes.MainRoutes
import dev.carlosivis.pokedex.feature.main.ui.details.DetailsNavigation
import dev.carlosivis.pokedex.feature.main.ui.home.HomeNavigation
import dev.carlosivis.pokedex.feature.main.ui.splash.SplashNavigation

internal class MainNavigationImpl (private val navManager: NavigationManager
) : SplashNavigation,
    HomeNavigation,
    DetailsNavigation {
    override fun navigateToDetails(id: String) {
        navManager.navigate(route = MainRoutes.Details.createRoute(id))
    }

    override fun popBackStack() {
        navManager.popBackStack()
    }

    override fun navigateToHome() {
        navManager.navigate(route = MainRoutes.Home.createRoute())
    }
}