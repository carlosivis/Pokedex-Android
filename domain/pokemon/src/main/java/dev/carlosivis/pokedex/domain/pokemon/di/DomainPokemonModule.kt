package dev.carlosivis.pokedex.domain.pokemon.di

import dev.carlosivis.pokedex.domain.pokemon.usecase.GetAllPokemonsUseCase
import dev.carlosivis.pokedex.domain.pokemon.usecase.GetPokemonUseCase
import dev.carlosivis.pokedex.domain.pokemon.usecase.GetPokemonsPageUseCase
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainPokemonModule = module {
    factory { (scope: CoroutineScope) -> GetPokemonUseCase(scope,get()) }
    factory { (scope: CoroutineScope) -> GetAllPokemonsUseCase(scope,get()) }
    factory { (scope: CoroutineScope) -> GetPokemonsPageUseCase(scope,get()) }
}