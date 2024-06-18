package dev.carlosivis.pokedex.domain.pokemon.model

data class PokemonPageDomain(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonNameDomain>
)
