package dev.carlosivis.pokedex.domain.pokemon.model

data class PokemonDomain(
    val id: String,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<PokemonTypesDomain>,
    val abilities: List<PokemonAbilitiesDomain>,
    val stats: List<PokemonStatsDomain>
)

