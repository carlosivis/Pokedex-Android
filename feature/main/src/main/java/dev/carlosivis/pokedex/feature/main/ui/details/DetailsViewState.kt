package dev.carlosivis.pokedex.feature.main.ui.details

import dev.carlosivis.pokedex.feature.main.model.PokemonModel

data class DetailsViewState(
    val pokemon: PokemonModel? = null,
    val isLoading: Boolean = false,
    val error: Throwable? = null
)