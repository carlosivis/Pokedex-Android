package dev.carlosivis.pokedex.domain.pokemon.model

data class PokemonStatsDomain(
    val stat: PokemonStatDomain,
    val baseStat: Int,
){
    companion object{
        val mock= PokemonStatsDomain(
            stat = PokemonStatDomain.mock,
            baseStat = 10
        )
    }
}

data class PokemonStatDomain(
    val name: String,
    val url: String,
){
    companion object {
        val mock = PokemonStatDomain(
            name = "HP",
            url = "example.com"
        )
    }
}