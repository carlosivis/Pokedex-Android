package dev.carlosivis.pokedex.core.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.carlosivis.pokedex.core.navigation.graph.addMainGraph
import dev.carlosivis.pokedex.core.navigation.routes.MainRoutes

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = MainRoutes.branch.route
    ) {
        addMainGraph()
    }
}