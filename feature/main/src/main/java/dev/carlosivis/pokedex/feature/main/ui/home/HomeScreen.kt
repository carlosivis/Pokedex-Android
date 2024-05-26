package dev.carlosivis.pokedex.feature.main.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.carlosivis.pokedex.core.uikit.components.LazyColumnPaging
import dev.carlosivis.pokedex.feature.main.model.PokemonModel
import dev.carlosivis.pokedex.feature.main.ui.home.HomeViewAction.Get
import dev.carlosivis.pokedex.feature.main.ui.home.HomeViewAction.Navigate


@Composable
fun HomeScreen(viewModel: HomeViewModel){
    val state by viewModel.state.collectAsState()
    Content(state = state, action = viewModel::dispatchAction)

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
                PokemonNameCard(it){action(Navigate.Details(it))}
            }
        )
    }

}

@Composable
fun PokemonNameCard(
    data: PokemonModel,
    onClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(12.dp),
        onClick = {onClick()}
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
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
    PokemonNameCard(data = PokemonModel(name = "Bulbasaur", url = ""), onClick = {})
}

