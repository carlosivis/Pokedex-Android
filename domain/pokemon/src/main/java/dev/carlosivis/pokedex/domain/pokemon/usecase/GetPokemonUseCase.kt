package dev.carlosivis.pokedex.domain.pokemon.usecase

import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.core.commons.base.UseCase
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonInfoDomain
import dev.carlosivis.pokedex.domain.pokemon.repository.PokemonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetPokemonUseCase(scope: CoroutineScope,
                        private val repository: PokemonRepository
): UseCase<PokemonInfoDomain, PokemonDomain>(scope){

    override suspend fun run(params: PokemonInfoDomain?): Flow<Either<PokemonDomain>> {
        return repository.getPokemon(params!!.id)
    }

}