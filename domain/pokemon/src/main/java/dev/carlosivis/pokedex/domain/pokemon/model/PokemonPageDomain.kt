package dev.carlosivis.pokedex.domain.pokemon.model

data class PokemonPageDomain(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonNameDomain>
){
    companion object{
        val mock = PokemonPageDomain(
            count = 10,
            next = "example.com",
            previous = null,
            results = listOf(PokemonNameDomain.mock)
        )
    }
}
