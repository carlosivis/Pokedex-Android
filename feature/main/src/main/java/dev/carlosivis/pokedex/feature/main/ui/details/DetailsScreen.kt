package dev.carlosivis.pokedex.feature.main.ui.details


import PokeballLoadingAnimation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.carlosivis.pokedex.feature.main.model.PokemonStats
import dev.carlosivis.pokedex.feature.main.model.PokemonType
import dev.carlosivis.pokedex.feature.main.util.getTypeColor


@Composable
fun DetailsScreen(
    pokemonId: String?,
    viewModel: DetailsViewModel
) {
    val state by viewModel.state.collectAsState()
    val action = viewModel::dispatchAction

    LaunchedEffect(Unit) {
        action(DetailsViewAction.Set.Pokemon(pokemonId))
    }

    Content(state = state, action = action)
}

@Composable
private fun Content(
    state: DetailsViewState,
    action: (DetailsViewAction) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        PokeballLoadingAnimation(state.isLoading)
        AsyncImage(
                modifier = Modifier.height(400.dp),
                model = state.pokemon?.getImageUrl(),
                contentDescription = null
            )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            modifier = Modifier.padding(8.dp).align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            state = rememberLazyListState()
        ) {
            state.pokemon?.types?.forEach {
                item {
                    PokemonTypeChip(it.type)
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = state.pokemon?.name ?: "",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Stats Base",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(8.dp))
        state.pokemon?.stats?.forEach {
            PokemonStatRow(it)
        }
    }
}

@Composable
private fun PokemonStatRow(stat: PokemonStats) {
    val progress = stat.baseStat / 200f
    val color = when (stat.stat.name) {
        "hp" -> Color(0xFFFFC1C1) // Suave vermelho pastel
        "attack" -> Color(0xFFFFE4B5) // Suave laranja pastel
        "defense" -> Color(0xFFADD8E6) // Suave azul pastel
        "speed" -> Color(0xFF98FB98)
        else -> Color.Gray
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = stat.stat.name,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .weight(3f)
                .height(24.dp)
                .background(color.copy(alpha = 0.3f), shape = RoundedCornerShape(12.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(progress)
                    .background(color, shape = RoundedCornerShape(12.dp))
            ) {
                Text(
                    text = stat.baseStat.toString(),
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White
                )
            }
        }
    }
}

@Composable
private fun PokemonTypeChip(type: PokemonType) {
    Box(
        modifier = Modifier
            .background(color = getTypeColor(type.name), shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp).defaultMinSize(60.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = type.name.replaceFirstChar { it.uppercase() },
            style = MaterialTheme.typography.body2,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PokemonTypePreview() {
    PokemonTypeChip(PokemonType(name = "grass", url = ""))
}
