package dev.carlosivis.pokedex.repository.datasource.remote

import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonNameDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonPageDomain

interface PokemonRemoteDataSource {

    suspend fun getAll(): Either <PokemonPageDomain>

    suspend fun getPokemon(id: Int): Either <PokemonDomain>

    suspend fun getPages(limit: Int, offset: Int): Either <PokemonPageDomain>
}