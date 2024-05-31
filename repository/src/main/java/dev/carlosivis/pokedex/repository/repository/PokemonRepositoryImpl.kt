package dev.carlosivis.pokedex.repository.repository

import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonNameDomain
import dev.carlosivis.pokedex.domain.pokemon.repository.PokemonRepository
import dev.carlosivis.pokedex.repository.datasource.local.PokemonLocalDataSource
import dev.carlosivis.pokedex.repository.datasource.remote.PokemonRemoteDataSource
import kotlinx.coroutines.flow.Flow

internal class PokemonRepositoryImpl (
    private val remote: PokemonRemoteDataSource,
    private val local: PokemonLocalDataSource
): PokemonRepository{
    override suspend fun getAll(): Flow<Either<Unit>> {
        //TODO: local data source
        TODO(remote.getAll().toString())
    }

    override suspend fun getPokemon(id: Int): Flow<Either<PokemonDomain>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPages(page: Int, count: Int): Flow<Either<List<PokemonNameDomain>>> {
        TODO("Not yet implemented")
    }
}