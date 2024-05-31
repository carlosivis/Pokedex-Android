package dev.carlosivis.pokedex.data.remote.datasource

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.core.commons.base.mapCatching
import dev.carlosivis.pokedex.core.commons.base.runCatchSuspendData
import dev.carlosivis.pokedex.data.remote.core.NetworkWrapper
import dev.carlosivis.pokedex.data.remote.model.PokemonNameResponse
import dev.carlosivis.pokedex.data.remote.model.PokemonResponse
import dev.carlosivis.pokedex.data.remote.model.mapToDomain
import dev.carlosivis.pokedex.data.remote.service.PokemonService
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonNameDomain
import dev.carlosivis.pokedex.repository.datasource.remote.PokemonRemoteDataSource

class PokemonRemoteDataSourceImpl(
    private val service: PokemonService
): PokemonRemoteDataSource {
    override suspend fun getAll(): Either<List<PokemonNameDomain>> {
        return runCatchSuspendData {
            val json = NetworkWrapper.getJson { service.getAll() }
            val mapType = object : TypeToken<Map<String, List<PokemonNameDomain>>>() {}.type
            val pokemonSets: Map<String, List<PokemonNameResponse>> = Gson().fromJson(json, mapType)
            pokemonSets
        }.mapCatching { map ->
            map.flatMap { (_, pokemonSets) ->
                pokemonSets.mapToDomain()}
        }
    }

    override suspend fun getPokemon(id: Int): Either<PokemonDomain> {
        return runCatchSuspendData {
            val json = NetworkWrapper.getJson { service.getPokemon(id) }
            val  mapType = object : TypeToken<Map<String, PokemonDomain>>() {}.type
            val pokemonSet: Map<String, PokemonResponse> = Gson().fromJson(json, mapType)
            pokemonSet
        }.mapCatching { map ->
            map.values.first().mapToDomain()
        }
    }

    override suspend fun getPages(page: Int, count: Int): Either<List<PokemonNameDomain>> {
        TODO("Not yet implemented")
    }
}