package dev.carlosivis.pokedex.feature.main.ui.home

import dev.carlosivis.pokedex.feature.main.model.PokemonNameModel

interface HomeNavigation {
    fun navigateToDetails(pokemon: PokemonNameModel)
}