package dev.carlosivis.pokedex.data.remote.model

import com.google.gson.annotations.SerializedName
import dev.carlosivis.pokedex.core.commons.extension.Empty
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonPageDomain

internal data class PokemonPageResponse(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val results: List<PokemonNameResponse>? = emptyList()
){

    fun mapToDomain(): PokemonPageDomain{
        return PokemonPageDomain(
            count = count ?: 0,
            next = next ?: String.Empty ,
            previous = previous ?: String.Empty,
            results = results!!.map { it.mapToDomain() }
        )
    }
}
