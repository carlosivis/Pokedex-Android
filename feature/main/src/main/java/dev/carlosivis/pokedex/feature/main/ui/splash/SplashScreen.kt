package dev.carlosivis.pokedex.feature.main.ui.splash

import android.window.SplashScreen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.carlosivis.pokedex.feature.main.ui.splash.draws.RotatingPokeBall
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(viewModel: SplashViewModel){
    Content()
    LaunchedEffect(Unit) {
        delay(4000L)
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
        RotatingPokeBall()
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    Content()
}