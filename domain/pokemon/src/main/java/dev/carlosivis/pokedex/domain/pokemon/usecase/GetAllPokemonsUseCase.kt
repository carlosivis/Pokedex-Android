package dev.carlosivis.pokedex.domain.pokemon.usecase

import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.core.commons.base.UseCase
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonNameDomain
import dev.carlosivis.pokedex.domain.pokemon.repository.PokemonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetAllPokemonsUseCase (
    scope: CoroutineScope,
    private val repository: PokemonRepository
): UseCase<Unit, List<PokemonNameDomain>>(scope){

    override suspend fun run(params: Unit?): Flow<Either<List<PokemonNameDomain>>> {
        return repository.getAll()
    }

}