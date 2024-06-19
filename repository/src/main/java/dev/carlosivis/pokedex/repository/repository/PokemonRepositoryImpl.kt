package dev.carlosivis.pokedex.repository.repository

import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.core.commons.base.onFailureSuspend
import dev.carlosivis.pokedex.core.commons.base.onSuccessSuspend
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonPageDomain
import dev.carlosivis.pokedex.domain.pokemon.repository.PokemonRepository
import dev.carlosivis.pokedex.repository.datasource.remote.PokemonRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class PokemonRepositoryImpl (
    private val remote: PokemonRemoteDataSource,
   // private val local: PokemonLocalDataSource
): PokemonRepository{
    override suspend fun getAll(): Flow<Either<PokemonPageDomain>> = flow {
        //TODO: local data source
        remote.getAll()
            .onSuccessSuspend {
                emit(Either.Success(it))
            }
            .onFailureSuspend {
                emit(Either.Failure(it))
            }
    }

    override suspend fun getPokemon(id: String?): Flow<Either<PokemonDomain>> = flow {
        remote.getPokemon(id)
            .onSuccessSuspend {
                emit(Either.Success(it))
            }
            .onFailureSuspend {
                emit(Either.Failure(it))
            }
    }

    override suspend fun getPages(limit: Int, offset: Int): Flow<Either<PokemonPageDomain>> = flow {
        remote.getPages(limit, offset)
            .onSuccessSuspend {
                emit(Either.Success(it))
            }
            .onFailureSuspend {
                emit(Either.Failure(it))
            }
    }
}