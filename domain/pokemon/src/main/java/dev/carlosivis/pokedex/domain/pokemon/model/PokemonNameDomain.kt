package dev.carlosivis.pokedex.domain.pokemon.model

data class PokemonNameDomain(
    val name: String,
    val url: String
){
    companion object{
        val mock = PokemonNameDomain(
            name = "Bulbasaur",
            url = "example.com"
        )
    }
}
