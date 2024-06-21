package dev.carlosivis.pokedex.domain.pokemon.model

data class PokemonTypesDomain(
    val slot: Int,
    val type: PokemonTypeDomain
)


data class PokemonTypeDomain(
    val name: String,
    val url: String
)
