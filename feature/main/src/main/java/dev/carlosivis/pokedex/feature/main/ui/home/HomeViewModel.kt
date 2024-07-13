package dev.carlosivis.pokedex.feature.main.ui.home

import androidx.lifecycle.ViewModel
import dev.carlosivis.pokedex.core.delegate.useCase
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonPage
import dev.carlosivis.pokedex.domain.pokemon.usecase.GetPokemonsPageUseCase
import dev.carlosivis.pokedex.feature.main.model.mapToModel
import dev.carlosivis.pokedex.feature.main.ui.home.HomeViewAction.Set
import dev.carlosivis.pokedex.feature.main.ui.home.HomeViewAction.Get
import dev.carlosivis.pokedex.feature.main.ui.home.HomeViewAction.Navigate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class HomeViewModel(
    private val navigation: HomeNavigation
): ViewModel(),KoinComponent{
    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    private val getPokemonsPageUseCase: GetPokemonsPageUseCase by useCase()

    private fun setLoading(isLoading: Boolean) {
        _state.update { it.copy(isLoading = isLoading) }
    }

    fun dispatchAction(action: HomeViewAction) {
        when (action) {
            is Navigate.Details -> navigation.navigateToDetails(action.pokemonId)
            is Set.Loading -> setLoading(action.isLoading)
            is Get.Page.Next -> getNextPage()
            is Get.Page.First -> getFirstPage()
        }
    }


    private fun getNextPage() {
        dispatchAction(Set.Loading(true))
        getPokemonsPageUseCase(
            params = PokemonPage(
                limit = 50,
                offset = state.value.offset+50,
            ),
            onSuccess = { pokemons ->
                _state.update {
                    val currentPokemons = it.pokemons.toMutableList()
                    val newPokemons = pokemons.results.mapToModel().filter { newPokemon ->
                        !currentPokemons.any { currentPokemon -> currentPokemon.name == newPokemon.name }
                    }
                    currentPokemons.addAll(newPokemons)
                    it.copy(
                        pokemons = currentPokemons,
                        offset = state.value.offset + 30
                    )}
            dispatchAction(Set.Loading(false))
            },
            onFailure = { error ->
                _state.update { it.copy(error = error) }
                dispatchAction(Set.Loading(false))
            }
        )
    }
    private fun getFirstPage() {
        dispatchAction(Set.Loading(true))
        getPokemonsPageUseCase(
            params = PokemonPage(
                limit = 30,
                offset = 0,
            ),
            onSuccess = { pokemons ->
                _state.update {
                    val pokelist = it.pokemons.toMutableList()
                    pokelist.addAll(pokemons.results.mapToModel())
                    it.copy(
                        pokemons = pokelist,
                        offset = 0)
                }
                dispatchAction(Set.Loading(false))
            },
            onFailure = { error ->
                _state.update { it.copy(error = error) }
                dispatchAction(Set.Loading(false))
            }
        )
    }
}