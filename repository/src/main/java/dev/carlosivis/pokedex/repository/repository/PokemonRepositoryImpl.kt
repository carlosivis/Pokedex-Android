package dev.carlosivis.pokedex.repository.repository

import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.core.commons.base.onFailureSuspend
import dev.carlosivis.pokedex.core.commons.base.onSuccessSuspend
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonNameDomain
import dev.carlosivis.pokedex.domain.pokemon.repository.PokemonRepository
import dev.carlosivis.pokedex.repository.datasource.local.PokemonLocalDataSource
import dev.carlosivis.pokedex.repository.datasource.remote.PokemonRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class PokemonRepositoryImpl (
    private val remote: PokemonRemoteDataSource,
   // private val local: PokemonLocalDataSource
): PokemonRepository{
    override suspend fun getAll(): Flow<Either<List<PokemonNameDomain>>> = flow {
        //TODO: local data source
        remote.getAll()
            .onSuccessSuspend {
                emit(Either.Success(it))
            }
            .onFailureSuspend {
                emit(Either.Failure(it))
            }
    }

    override suspend fun getPokemon(id: Int): Flow<Either<PokemonDomain>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPages(page: Int, count: Int): Flow<Either<List<PokemonNameDomain>>> {
        TODO("Not yet implemented")
    }
}