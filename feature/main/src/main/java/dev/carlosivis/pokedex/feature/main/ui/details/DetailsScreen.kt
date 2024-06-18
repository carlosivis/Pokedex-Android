package dev.carlosivis.pokedex.feature.main.ui.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dev.carlosivis.pokedex.feature.main.model.PokemonModel


@Composable
fun DetailsScreen(
    pokemonId: String?,
    viewModel: DetailsViewModel){
    val state by viewModel.state.collectAsState()
    val action = viewModel::dispatchAction

    Content(state = state, action = viewModel::dispatchAction)

    LaunchedEffect(Unit) {
        action(DetailsViewAction.Set.Pokemon(pokemonId))
    }

}

@Composable
private fun Content(
    state: DetailsViewState,
    action: (DetailsViewAction) -> Unit){
    TODO()
    }