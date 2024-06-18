package dev.carlosivis.pokedex.feature.main.ui.splash

import androidx.lifecycle.ViewModel
import dev.carlosivis.pokedex.feature.main.ui.splash.SplashViewAction.Navigate
import org.koin.core.component.KoinComponent

class SplashViewModel(
    private val navigation: SplashNavigation
): ViewModel(),KoinComponent {

    fun dispatchAction(action: SplashViewAction) {
        when (action) {
            is Navigate.Home -> navigation.navigateToHome()
        }


    }
}