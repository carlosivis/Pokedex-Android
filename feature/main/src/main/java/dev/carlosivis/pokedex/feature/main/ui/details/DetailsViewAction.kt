package dev.carlosivis.pokedex.feature.main.ui.details

sealed class DetailsViewAction {
    sealed class Navigate : DetailsViewAction() {
        object PopBackStack : Navigate()

    }

    sealed class Set: DetailsViewAction() {
        data class Pokemon(val pokemon: String?) : Set()

        data class Loading(val isLoading: Boolean): Set()
    }
}