package dev.carlosivis.pokedex.feature.main.ui.home

import dev.carlosivis.pokedex.feature.main.model.PokemonModel

sealed class HomeViewAction {

    object Get {
        object Pokemon : HomeViewAction()
        object Page {
            object Next : HomeViewAction()
        }
    }
    object Navigate{
      data class Details(val pokemon: PokemonModel): HomeViewAction()
    }
    object Set {
        data class Loading(val isLoading: Boolean): HomeViewAction()
    }
}