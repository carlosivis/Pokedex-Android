package dev.carlosivis.pokedex.feature.main.ui.splash

sealed class SplashViewAction {
    sealed class Navigate : SplashViewAction(){
        object Home : Navigate()
    }
}