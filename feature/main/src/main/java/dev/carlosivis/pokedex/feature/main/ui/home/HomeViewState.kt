package dev.carlosivis.pokedex.feature.main.ui.home

import dev.carlosivis.pokedex.feature.main.model.PokemonNameModel

data class HomeViewState(
    val offset: Int = 0,
    val error: Throwable? = null,
    val isLoading: Boolean = false,
    val pokemons: List<PokemonNameModel> = emptyList()
)
