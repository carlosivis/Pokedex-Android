package dev.carlosivis.pokedex.domain.pokemon.model

data class PokemonAbilitiesDomain(
    val ability: PokemonAbilityDomain,
    val isHidden: Boolean,
    val slot: Int
){
    companion object {
        val mock = PokemonAbilitiesDomain(
            ability = PokemonAbilityDomain.mock,
            isHidden = false,
            slot = 1
        )
    }
}

data class PokemonAbilityDomain(
    val name: String,
    val url: String
){
    companion object{
        val mock = PokemonAbilityDomain(
            name = "mock",
            url = "example.com"
        )
    }
}