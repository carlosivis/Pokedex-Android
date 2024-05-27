package dev.carlosivis.pokedex.feature.main.ui.home

import androidx.lifecycle.ViewModel
import dev.carlosivis.pokedex.feature.main.ui.home.HomeViewAction.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class HomeViewModel(
    private val navigation: HomeNavigation
): ViewModel(),KoinComponent{
    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    private fun setLoading(isLoading: Boolean) {
        _state.update { it.copy(isLoading = isLoading) }
    }

    fun dispatchAction(action: HomeViewAction) {
        when (action) {
            is Navigate.Details -> navigation.navigateToDetails(action.pokemon)
            is HomeViewAction.Set.Loading -> setLoading(action.isLoading)
            is Get.Page.Next -> TODO()
            is Get.Pokemon -> TODO()
        }
    }


}