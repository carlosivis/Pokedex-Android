package dev.carlosivis.pokedex.domain.pokemon.model

data class PokemonStatsDomain(
    val stat: PokemonStatDomain,
    val baseStat: Int,
)

data class PokemonStatDomain(
    val name: String,
    val url: String,
)