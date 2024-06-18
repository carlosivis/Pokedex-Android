package dev.carlosivis.pokedex.feature.main.ui.home

import dev.carlosivis.pokedex.feature.main.model.PokemonNameModel

sealed class HomeViewAction {

    object Get {
        object Pokemon : HomeViewAction()
        object Page {
            object Next : HomeViewAction()
            object First : HomeViewAction()
        }
    }
    object Navigate{
      data class Details(val pokemonId: String): HomeViewAction()
    }
    object Set {
        data class Loading(val isLoading: Boolean): HomeViewAction()
    }
}