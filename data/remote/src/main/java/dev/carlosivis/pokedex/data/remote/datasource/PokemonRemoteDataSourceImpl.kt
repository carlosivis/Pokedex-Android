package dev.carlosivis.pokedex.data.remote.datasource

import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.core.commons.base.runCatchSuspendData
import dev.carlosivis.pokedex.data.remote.service.PokemonService
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonNameDomain
import dev.carlosivis.pokedex.repository.datasource.remote.PokemonRemoteDataSource
import kotlinx.coroutines.flow.Flow

class PokemonRemoteDataSourceImpl(
    private val service: PokemonService
): PokemonRemoteDataSource {
    override fun getAll(): Flow<Either<List<PokemonNameDomain>>> {
        TODO("Not yet implemented")
    }

    override fun getPokemon(id: Int): Flow<Either<PokemonDomain>> {
        TODO("Not yet implemented")
    }

    override fun getPages(page: Int, count: Int): Flow<Either<List<PokemonNameDomain>>> {
        TODO("Not yet implemented")
    }
}