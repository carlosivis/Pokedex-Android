package dev.carlosivis.pokedex.domain.pokemon.model

data class PokemonAbilitiesDomain(
    val ability: PokemonAbilityDomain,
    val isHidden: Boolean,
    val slot: Int
)

data class PokemonAbilityDomain(
    val name: String,
    val url: String
)