package dev.carlosivis.pokedex.feature.main.ui.details

import androidx.lifecycle.ViewModel
import dev.carlosivis.pokedex.feature.main.model.PokemonModel
import dev.carlosivis.pokedex.feature.main.ui.details.DetailsViewAction.Navigate
import dev.carlosivis.pokedex.feature.main.ui.details.DetailsViewAction.Set
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class DetailsViewModel(
    private val navigation: DetailsNavigation
): ViewModel(),KoinComponent {
    private val _state = MutableStateFlow(DetailsViewState())
    val state = _state.asStateFlow()

    fun dispatchAction(action: DetailsViewAction) {
        when (action) {
            is Navigate.PopBackStack -> navigation.popBackStack()
            is Set.Pokemon -> TODO()
        }
    }

    private fun setPokemon(pokemon: PokemonModel?) {
        if (pokemon == null) {
            _state.update { it.copy(pokemon = null) }
        } else{
            TODO()
        }
    }
}