package dev.carlosivis.pokedex.feature.main.ui.details


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.carlosivis.pokedex.feature.main.model.PokemonType
import dev.carlosivis.pokedex.feature.main.util.getTypeColor


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


    val scrollState = rememberLazyListState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ){
        AsyncImage(
            modifier = Modifier.height(400.dp),
            model = state.pokemon?.getImageUrl(),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            state = scrollState){
            state.pokemon?.types?.forEach {
                item {
                    PokemonType(it.type)
                }
            }
        }
        Text(
            text = state.pokemon?.name ?: ""
        )
    }
}

@Composable
private fun PokemonType(
    type: PokemonType) {

    Card(shape = RoundedCornerShape(12.dp),
        backgroundColor = getTypeColor(type.name),
        ){
        Row(modifier = Modifier.padding(4.dp).defaultMinSize(48.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(4.dp),
                fontSize = 18.sp,
                text = type.name,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun PokemonTypePreview() {
    PokemonType(PokemonType(name = "Grass", url = ""))
}