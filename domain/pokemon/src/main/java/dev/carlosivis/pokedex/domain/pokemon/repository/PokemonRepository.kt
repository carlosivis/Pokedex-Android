package dev.carlosivis.pokedex.domain.pokemon.repository

import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonNameDomain
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    suspend fun getAll(): Flow<Either<List<PokemonNameDomain>>>

    suspend fun getPokemon(id:Int): Flow<Either<PokemonDomain>>

    suspend fun getPages(page:Int, count:Int): Flow<Either<List<PokemonNameDomain>>>
}