package dev.carlosivis.pokedex.feature.main.di

import dev.carlosivis.pokedex.feature.main.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val mainFeatureModule = module{
    viewModel { HomeViewModel(get()) }
}