package dev.carlosivis.pokedex.repository.datasource.remote

import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonNameDomain
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {

    suspend fun getAll(): Either <List<PokemonNameDomain>>

    suspend fun getPokemon(id: Int): Either <PokemonDomain>

    suspend fun getPages(page: Int, count: Int): Either <List<PokemonNameDomain>>
}