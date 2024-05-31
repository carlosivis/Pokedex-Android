package dev.carlosivis.pokedex.repository.datasource.remote

import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonNameDomain
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {

    fun getAll(): Flow<Either <List<PokemonNameDomain>>>

    fun getPokemon(id: Int): Flow<Either <PokemonDomain>>

    fun getPages(page: Int, count: Int): Flow<Either <List<PokemonNameDomain>>>
}