package dev.carlosivis.pokedex.data.remote.model

import com.google.gson.annotations.SerializedName
import dev.carlosivis.pokedex.core.commons.extension.Empty
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonNameDomain

internal class PokemonNameResponse(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
) {
    fun mapToDomain(): PokemonNameDomain {
        return PokemonNameDomain(
            name = name ?: String.Empty,
            url = url ?: String.Empty
        )
    }
}
internal fun List<PokemonNameResponse>.mapToDomain() = map { it.mapToDomain() }
