package dev.carlosivis.pokedex.data.remote.di

import dev.carlosivis.pokedex.data.remote.BuildConfig
import dev.carlosivis.pokedex.data.remote.core.Retrofit
import dev.carlosivis.pokedex.data.remote.datasource.PokemonRemoteDataSourceImpl
import dev.carlosivis.pokedex.data.remote.interceptor.HearderInterceptor
import dev.carlosivis.pokedex.data.remote.service.PokemonService
import dev.carlosivis.pokedex.repository.datasource.remote.PokemonRemoteDataSource
import okhttp3.Interceptor
import org.koin.dsl.module

val remoteDataModule = module {
    factory<Interceptor> { HearderInterceptor() }

    factory<PokemonService> {
        Retrofit(
            baseUrl = BuildConfig.BASE_URL,
            interceptor = get()
        )
    }

    single<PokemonRemoteDataSource>{ PokemonRemoteDataSourceImpl(get()) }
}

