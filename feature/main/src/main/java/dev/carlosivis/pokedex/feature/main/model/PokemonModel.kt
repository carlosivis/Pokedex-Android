package dev.carlosivis.pokedex.feature.main.model

import android.os.Parcelable
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonModel(
    val id: String,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<PokemonTypes>,
    val abilities: List<PokemonAbilities>,
    val stats: List<PokemonStats>
): Parcelable{
    fun mapToDomain(): PokemonDomain {
        return PokemonDomain(
            id = id,
            name = name,
            height = height,
            weight = weight,
            types = types.map { it.mapToDomain() },
            abilities = abilities.map { it.mapToDomain() },
            stats = stats.map { it.mapToDomain() }
        )
    }
    fun getImageUrl(): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                "pokemon/other/official-artwork/$id.png"
    }


    companion object{
        val mock = PokemonModel(
            id = "1",
            name = "Bulbasaur",
            height = 7,
            weight = 6,
            types = listOf(PokemonTypes.mock),
            abilities = listOf(PokemonAbilities.mock),
            stats = listOf(PokemonStats.mock)
        )
    }
}


internal fun PokemonDomain.mapToModel(): PokemonModel{
    return PokemonModel(
        id = id,
        name = name,
        height = height,
        weight = weight,
        types = types.map { it.mapToModel() },
        abilities = abilities.map { it.mapToModel() },
        stats = stats.map { it.mapToModel() }
    )

}
