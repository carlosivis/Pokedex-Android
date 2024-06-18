@file:OptIn(ExperimentalMaterialApi::class)

package dev.carlosivis.pokedex.feature.main.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import dev.carlosivis.pokedex.core.uikit.components.LazyColumnPaging
import dev.carlosivis.pokedex.feature.main.R
import dev.carlosivis.pokedex.feature.main.model.PokemonNameModel
import dev.carlosivis.pokedex.feature.main.ui.home.HomeViewAction.Get
import dev.carlosivis.pokedex.feature.main.ui.home.HomeViewAction.Navigate


@Composable
fun HomeScreen(viewModel: HomeViewModel){
    val state by viewModel.state.collectAsState()
    val action = viewModel::dispatchAction
    Content(state = state, action = viewModel::dispatchAction)
    LaunchedEffect(Unit) {
        action(Get.Page.First)
    }
}

@Composable
private fun Content(
    state: HomeViewState,
    action: (HomeViewAction) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {

        LazyColumnPaging(
            modifier = Modifier.weight(1f),
            items = state.pokemons,
            requestNewPage = { action(Get.Page.Next)},
            itemContent = {
                PokemonNameCard(it){action(Navigate.Details(it.name))}
            }
        )
    }

}

@Composable
fun PokemonNameCard(
    data: PokemonNameModel,
    onClick: () -> Unit
) {
    Button (
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
        onClick = {onClick()}
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = data.getImageUrl(),
                contentDescription = null,
                modifier = Modifier.height(130.dp),
                placeholder = painterResource(
                    id = dev.carlosivis.pokedex.core.uikit.R.drawable.pokemon_placeholder)
            )
            Text(
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                text = data.name)
        }

    }
    Spacer(modifier = Modifier.height(8.dp))
}



@Preview
@Composable
fun PokemonNameCardPreview() {
    PokemonNameCard(data = PokemonNameModel(name = "Bulbasaur", url = ""), onClick = {})
}

@Preview
@Composable
fun HomeScreenPreview() {
    Content(state = HomeViewState(pokemons = listOf(PokemonNameModel(name = "Bulbasaur", url = ""))), action = {})
}

