package dev.carlosivis.pokedex.feature.main.ui.home

import androidx.lifecycle.ViewModel
import dev.carlosivis.pokedex.core.delegate.useCase
import dev.carlosivis.pokedex.domain.pokemon.usecase.GetAllPokemonsUseCase
import dev.carlosivis.pokedex.domain.pokemon.usecase.GetPokemonUseCase
import dev.carlosivis.pokedex.feature.main.model.PokemonNameModel
import dev.carlosivis.pokedex.feature.main.model.mapToModel
import dev.carlosivis.pokedex.feature.main.ui.home.HomeViewAction.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class HomeViewModel(
    private val navigation: HomeNavigation
): ViewModel(),KoinComponent{
    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    private val getPokemonsUseCase: GetAllPokemonsUseCase by useCase()

    private fun setLoading(isLoading: Boolean) {
        _state.update { it.copy(isLoading = isLoading) }
    }

    fun dispatchAction(action: HomeViewAction) {
        when (action) {
            is Navigate.Details -> navigation.navigateToDetails(action.pokemonId)
            is HomeViewAction.Set.Loading -> setLoading(action.isLoading)
            is Get.Page.Next -> { setLoading(true); getPokemons() }
            is Get.Pokemon -> getPokemons()
        }
    }

    private fun getPokemons() {
        setLoading(true)
        getPokemonsUseCase(
            onSuccess = { pokemons ->
                _state.update {
                    val pokelist = it.pokemons.toMutableList()
                    pokelist.addAll(pokemons.mapToModel())
                    it.copy(pokemons = pokelist, isLoading = false)
                }
            },
            onFailure = { error ->
                _state.update { it.copy(error = error) }
            }
        )
    }
}