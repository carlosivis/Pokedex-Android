package dev.carlosivis.pokedex.domain.pokemon.usecase

import dev.carlosivis.pokedex.core.commons.base.Either
import dev.carlosivis.pokedex.core.commons.base.UseCase
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonNameDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonPage
import dev.carlosivis.pokedex.domain.pokemon.repository.PokemonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetPokemonsPageUseCase(
    scope: CoroutineScope,
    private val repository: PokemonRepository
): UseCase<PokemonPage,List<PokemonNameDomain>>(scope) {
    override suspend fun run(params: PokemonPage?): Flow<Either<List<PokemonNameDomain>>> {
        return repository.getPages(params!!.page, params.count)
    }
}