package dev.carlosivis.pokedex.feature.main.ui.splash

import PokeballLoadingAnimation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(viewModel: SplashViewModel) {
    Content()
    LaunchedEffect(Unit) {
        delay(2000L)
        viewModel.dispatchAction(SplashViewAction.Navigate.Home)
    }
}

@Composable
private fun Content() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PokeballLoadingAnimation(true)

    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    Content()
}