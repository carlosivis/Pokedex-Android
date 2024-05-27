package dev.carlosivis.pokedex.feature.main.ui.details

import dev.carlosivis.pokedex.feature.main.model.PokemonModel

sealed class DetailsViewAction {
    sealed class Navigate : DetailsViewAction() {
        object PopBackStack : Navigate()

    }

    sealed class Set: DetailsViewAction() {
        data class Pokemon(val pokemon: PokemonModel?) : Set()
    }
}