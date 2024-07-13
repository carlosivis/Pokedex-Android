package dev.carlosivis.pokedex.core.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.carlosivis.pokedex.core.navigation.routes.MainRoutes
import dev.carlosivis.pokedex.feature.main.ui.details.DetailsScreen
import dev.carlosivis.pokedex.feature.main.ui.home.HomeScreen
import dev.carlosivis.pokedex.feature.main.ui.splash.SplashScreen
import org.koin.androidx.compose.getViewModel

internal fun NavGraphBuilder.addMainGraph(){
    navigation(
        route = MainRoutes.branch.route,
        startDestination = MainRoutes.Home.createRoute()
    ){
        addHomeScreen()
        addDetailsScreen()
        addSplashScreen()
    }
}


private fun NavGraphBuilder.addSplashScreen(){
    composable(
        route = MainRoutes.Splash.createRoute()
    ) {
        SplashScreen(getViewModel())
    }
}
private fun NavGraphBuilder.addHomeScreen(){
    composable(
        route = MainRoutes.Home.createRoute()
    ) {
        HomeScreen(getViewModel())
    }
}
private fun NavGraphBuilder.addDetailsScreen(){
    composable(
        route = MainRoutes.Details.createRoute(),
        arguments = MainRoutes.Details.arguments
    ){
        val id = it.arguments?.getString(MainRoutes.pokemon_arg)
        DetailsScreen(
            pokemonId = id,
            getViewModel())
    }
}