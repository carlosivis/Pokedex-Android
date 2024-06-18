package dev.carlosivis.pokedex.domain.pokemon.repository

import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonNameDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonPageDomain
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    suspend fun getAll(): Flow<Either<PokemonPageDomain>>

    suspend fun getPokemon(id:Int): Flow<Either<PokemonDomain>>

    suspend fun getPages(limit:Int, offset:Int): Flow<Either<PokemonPageDomain>>
}