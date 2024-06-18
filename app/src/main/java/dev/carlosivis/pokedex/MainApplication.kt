package dev.carlosivis.pokedex

import android.app.Application
import dev.carlosivis.pokedex.core.navigation.di.navigationModule
import dev.carlosivis.pokedex.data.remote.di.remoteDataModule
import dev.carlosivis.pokedex.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    navigationModule,
                    remoteDataModule,
                    repositoryModule
                )
            )
        }.androidContext(this)
    }
}