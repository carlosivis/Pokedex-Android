package dev.carlosivis.pokedex.core.navigation.routes

import androidx.navigation.NavType
import dev.carlosivis.pokedex.core.navigation.core.Routes
import dev.carlosivis.pokedex.core.navigation.destination.BranchDestination
import dev.carlosivis.pokedex.core.navigation.destination.LeafDestination
import dev.carlosivis.pokedex.core.navigation.destination.NavArg

object MainRoutes: Routes {
    override val branch: BranchDestination = BranchDestination.Main
    const val pokemon_arg = "pokemon_arg"

    object Splash : LeafDestination(root = branch, route = "splash")
    object Home : LeafDestination(root = branch, route = "home")

    object Details : LeafDestination(
        root = branch,
        route = "details",
        args = listOf(
            NavArg(id = pokemon_arg, type = NavType.StringType)
        )
    ) {
        fun createRoute(id: String) : String{
            return putArgs(pokemon_arg to id)
        }
    }

}