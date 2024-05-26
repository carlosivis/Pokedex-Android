package dev.carlosivis.pokedex.feature.main.ui.home

import dev.carlosivis.pokedex.feature.main.model.PokemonModel

interface HomeNavigation {
    fun navigateToDetails(pokemon: PokemonModel)
}