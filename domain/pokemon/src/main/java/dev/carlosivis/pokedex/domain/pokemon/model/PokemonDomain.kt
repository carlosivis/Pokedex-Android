package dev.carlosivis.pokedex.domain.pokemon.model

data class PokemonDomain(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<PokemonTypeDomain>,
    val abilities: List<PokemonAbilityDomain>,
    val stats: List<PokemonStatDomain>
)
data class PokemonTypeDomain(
    val name: String,
)
data class PokemonAbilityDomain(
    val name: String,
)
data class PokemonStatDomain(
    val name: String,
    val baseStat: Int,
)
