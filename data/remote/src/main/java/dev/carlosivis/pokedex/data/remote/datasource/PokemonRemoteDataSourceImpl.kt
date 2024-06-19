package dev.carlosivis.pokedex.data.remote.datasource

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.core.commons.base.mapCatching
import dev.carlosivis.pokedex.core.commons.base.runCatchSuspendData
import dev.carlosivis.pokedex.data.remote.core.NetworkWrapper
import dev.carlosivis.pokedex.data.remote.model.PokemonPageResponse
import dev.carlosivis.pokedex.data.remote.model.PokemonResponse
import dev.carlosivis.pokedex.data.remote.service.PokemonService
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonPageDomain
import dev.carlosivis.pokedex.repository.datasource.remote.PokemonRemoteDataSource

class PokemonRemoteDataSourceImpl(
    private val service: PokemonService
): PokemonRemoteDataSource {
    override suspend fun getAll(): Either<PokemonPageDomain> {
        return runCatchSuspendData {
            val json = NetworkWrapper.getJson { service.getAll() }
            val mapType = object : TypeToken<Map<String, PokemonPageDomain>>() {}.type
            val pokemonSets: PokemonPageResponse = Gson().fromJson(json, mapType)
            pokemonSets
        }.mapCatching { map ->
            map.mapToDomain()
        }
    }

    override suspend fun getPokemon(id: String?): Either<PokemonDomain> {
        return runCatchSuspendData {
            val json = NetworkWrapper.getJson { service.getPokemon(id) }
            val  mapType = object : TypeToken<Map<String, PokemonDomain>>() {}.type
            val pokemonSet: PokemonResponse = Gson().fromJson(json, mapType)
            pokemonSet
        }.mapCatching { map ->
            map.mapToDomain()
        }
    }

    override suspend fun getPages(limit: Int, offset: Int): Either<PokemonPageDomain> {
        return runCatchSuspendData {
            val json = NetworkWrapper.getJson { service.getPages(limit, offset) }
            val pokemonSet: PokemonPageResponse = Gson().fromJson(json, PokemonPageResponse::class.java)
            pokemonSet
        }.mapCatching { map ->
           map.mapToDomain() }
    }
}