package dev.carlosivis.pokedex.data.remote.model

import com.google.gson.annotations.SerializedName
import dev.carlosivis.pokedex.core.commons.extension.Empty
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonTypeDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonTypesDomain

internal data class PokemonTypesResponse(
    @SerializedName("slot")
    val slot: Int? = null,
    @SerializedName("type")
    val type:PokemonTypeResponse? = null
) {
    fun mapToDomain(): PokemonTypesDomain {
        return PokemonTypesDomain(
            slot = slot ?: 0,
            type = type!!.mapToDomain()
        )
    }
}

internal data class PokemonTypeResponse(
    @SerializedName("name")
    val name:String? = null,
    @SerializedName("url")
    val url:String? = null
) {
    fun mapToDomain(): PokemonTypeDomain {
        return PokemonTypeDomain(
            name = name ?: String.Empty,
            url = url ?: String.Empty
        )
    }
}