package dev.carlosivis.pokedex.feature.main.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
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
        action(Get.Pokemon)
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

        LazyColumn(
            modifier = Modifier.weight(1f),
            reverseLayout = true,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            userScrollEnabled = true,
            content = {
                items(state.pokemons) { pokemon ->
                    PokemonNameCard(pokemon) { action(Navigate.Details(pokemon.name)) }
                }
            }
        )
//        LazyColumnPaging(
//            modifier = Modifier.weight(1f),
//            items = state.pokemons,
//            requestNewPage = { action(Get.Page.Next)},
//            itemContent = {
//                PokemonNameCard(it){action(Navigate.Details(it.name))}
//            }
//        )
    }

}

@Composable
fun PokemonNameCard(
    data: PokemonNameModel,
    onClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(12.dp),
        onClick = {onClick()}
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data.getImageUrl())
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier.height(70.dp),
                placeholder = painterResource(org.koin.android.R.drawable.notification_bg)
            )
            Text(modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
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

