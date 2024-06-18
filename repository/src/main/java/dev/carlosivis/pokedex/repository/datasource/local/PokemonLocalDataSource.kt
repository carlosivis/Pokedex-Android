package dev.carlosivis.pokedex.repository.datasource.local

import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain

interface PokemonLocalDataSource {

    fun getIsEmpty(): Boolean

    fun savePokemons(pokemons: List<PokemonDomain>): Either<Unit>

    //TODO: Implementar pages e get all
}