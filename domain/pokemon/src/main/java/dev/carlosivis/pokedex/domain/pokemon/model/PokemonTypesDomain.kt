package dev.carlosivis.pokedex.domain.pokemon.model

data class PokemonTypesDomain(
    val slot: Int,
    val type: PokemonTypeDomain
){
    companion object{
        val mock = PokemonTypesDomain(
            slot = 1,
            type = PokemonTypeDomain.mock
        )
    }
}


data class PokemonTypeDomain(
    val name: String,
    val url: String
){
    companion object {
        val mock = PokemonTypeDomain(
            name = "grass",
            url = "example.com"
        )
    }
}
