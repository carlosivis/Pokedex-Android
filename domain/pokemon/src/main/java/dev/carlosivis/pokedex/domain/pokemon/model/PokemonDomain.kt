package dev.carlosivis.pokedex.domain.pokemon.model

data class PokemonDomain(
    val id: String,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<PokemonTypesDomain>,
    val abilities: List<PokemonAbilitiesDomain>,
    val stats: List<PokemonStatsDomain>
) {
    companion object{
        val mock = PokemonDomain(
            id = "1",
            name = "Bulbasaur",
            height = 7,
            weight = 6,
            types = listOf(PokemonTypesDomain.mock),
            abilities = listOf(PokemonAbilitiesDomain.mock),
            stats = listOf(PokemonStatsDomain.mock)
        )
    }
}

