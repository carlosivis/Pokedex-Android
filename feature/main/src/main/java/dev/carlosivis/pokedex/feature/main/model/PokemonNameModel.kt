package dev.carlosivis.pokedex.feature.main.model

import android.os.Parcelable
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonNameDomain
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonNameModel(
    val name: String,
    val url: String,
): Parcelable {

    fun mapToDomain(): PokemonNameDomain {
        return PokemonNameDomain(
            name,
            url)
    }

    fun getImageUrl(): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                "pokemon/other/official-artwork/$index.png"
    }
}

internal fun PokemonNameDomain.mapToModel(): PokemonNameModel {
    return PokemonNameModel(
        name,
        url)
}

internal fun List<PokemonNameDomain>.mapToModel() = map { it.mapToModel() }
