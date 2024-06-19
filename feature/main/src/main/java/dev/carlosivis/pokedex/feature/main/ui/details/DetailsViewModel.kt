package dev.carlosivis.pokedex.feature.main.ui.details

import androidx.lifecycle.ViewModel
import dev.carlosivis.pokedex.core.delegate.useCase
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonInfoDomain
import dev.carlosivis.pokedex.domain.pokemon.usecase.GetPokemonUseCase
import dev.carlosivis.pokedex.feature.main.model.mapToModel
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

    private val getPokemonUseCase: GetPokemonUseCase by useCase()

    private fun setLoading(isLoading: Boolean) {
        _state.update { it.copy(isLoading = isLoading) }
    }

    fun dispatchAction(action: DetailsViewAction) {
        when (action) {
            is Navigate.PopBackStack -> navigation.popBackStack()
            is Set.Pokemon -> setPokemon(action.pokemon)
            is Set.Loading -> setLoading(action.isLoading)
        }
    }

    private fun setPokemon(id: String?) {
        setLoading(false)

        if (id == null) {
            _state.update { it.copy(pokemon = null) }
        } else{
            getPokemonUseCase(
                params = PokemonInfoDomain(id),
                onSuccess = { pokemon ->
                    _state.update {
                        it.copy(pokemon =  pokemon.mapToModel()) }
                },
                onFailure = { error ->
                    _state.update { it.copy(error = error) }
                }
            )
        }
    }
}