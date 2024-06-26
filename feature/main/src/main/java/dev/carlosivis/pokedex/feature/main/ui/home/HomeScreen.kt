package dev.carlosivis.pokedex.feature.main.ui.home

import LazyGridPaging
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import coil.compose.AsyncImage
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.placeholder
import dev.carlosivis.pokedex.feature.main.model.PokemonNameModel
import dev.carlosivis.pokedex.feature.main.ui.home.HomeViewAction.Get
import dev.carlosivis.pokedex.feature.main.ui.home.HomeViewAction.Navigate
import java.util.Locale


@Composable
fun HomeScreen(viewModel: HomeViewModel) {
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
    action: (HomeViewAction) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {

        LazyGridPaging(
            modifier = Modifier.weight(1f),
            items = state.pokemons,
            requestNewPage = { action(Get.Page.Next) },
            itemContent = {
                PokemonNameCard(it) { action(Navigate.Details(it.name)) }
            }
        )
    }

}

@Composable
fun PokemonNameCard(
    data: PokemonNameModel,
    onClick: () -> Unit
) {
    var dominantColor by remember { mutableStateOf(Color.Transparent) }
    var isLoading by remember { mutableStateOf(true) }

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .placeholder(
                visible = isLoading,
                highlight = PlaceholderHighlight.shimmer(),
                color = Color.LightGray,
                shape = RoundedCornerShape(32.dp)
            ),
        shape = RoundedCornerShape(32.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = dominantColor),
        onClick = { onClick() }
    ) {
        Column(
            modifier = Modifier
                .padding(all = 2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PokemonImage(data.getImageUrl()) { color ->
                dominantColor = color
                isLoading = false
            }
            Text(
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                text = data.name.replaceFirstChar { it.uppercase(Locale.getDefault()) },
            )
        }
    }
}

@Composable
fun PokemonImage(
    imageUrl: String,
    onColorExtracted: (Color) -> Unit
) {

    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = Modifier.height(130.dp),
        onSuccess = { successResult ->
            val originalBitmap = (successResult.result.drawable as BitmapDrawable).bitmap
            val softwareBitmap = originalBitmap.copy(Bitmap.Config.ARGB_8888, false)
            Palette.from(softwareBitmap).generate { palette ->
                palette?.dominantSwatch?.rgb?.let { colorValue ->
                    onColorExtracted(Color(colorValue))
                }
            }
        },
    )
}


@Preview(showBackground = true)
@Composable
fun PokemonNameCardPreview() {
    PokemonNameCard(
        data = PokemonNameModel(
            name = "Bulbasaur",
            url = "https://example.com/image.jpg"
        ), onClick = {})
}


