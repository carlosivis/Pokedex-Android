package dev.carlosivis.pokedex.feature.main.ui.home

import dev.carlosivis.pokedex.feature.main.model.PokemonModel

data class HomeViewState(
    val error: Throwable? = null,
    val isLoading: Boolean = false,
    val pokemons: List<PokemonModel> = emptyList()
)
