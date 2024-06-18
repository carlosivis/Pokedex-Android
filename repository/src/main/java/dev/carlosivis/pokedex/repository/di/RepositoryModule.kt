package dev.carlosivis.pokedex.repository.di

import dev.carlosivis.pokedex.domain.pokemon.di.domainPokemonModule
import dev.carlosivis.pokedex.domain.pokemon.repository.PokemonRepository
import dev.carlosivis.pokedex.repository.repository.PokemonRepositoryImpl
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val repositoryModule = module {
    single<PokemonRepository> { PokemonRepositoryImpl(get()) }
    // TODO: add local single<PokemonRepository> { PokemonRepositoryImpl(get(), get()) }

    loadKoinModules(domainPokemonModule)
}