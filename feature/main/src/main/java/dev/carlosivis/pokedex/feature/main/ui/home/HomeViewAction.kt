package dev.carlosivis.pokedex.feature.main.ui.home

import dev.carlosivis.pokedex.feature.main.model.PokemonNameModel

sealed class HomeViewAction {

    object Get {
        object Pokemon : HomeViewAction()
        object Page {
            object Next : HomeViewAction()
        }
    }
    object Navigate{
      data class Details(val pokemon: PokemonNameModel): HomeViewAction()
    }
    object Set {
        data class Loading(val isLoading: Boolean): HomeViewAction()
    }
}