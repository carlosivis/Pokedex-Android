package dev.carlosivis.pokedex.data.remote.model

import com.google.gson.annotations.SerializedName
import dev.carlosivis.pokedex.core.commons.extension.Empty
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonStatDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonTypeDomain

internal data class PokemonResponse(
    @SerializedName("id")
    val id:String? = null,
    @SerializedName("name")
    val name:String? = null,
    @SerializedName("height")
    val height:Int? = null,
    @SerializedName("weight")
    val weight:Int? = null,
    @SerializedName("types")
    val types:List<PokemonTypesResponse>? = null,
    @SerializedName("abilities")
    val abilities:List<PokemonAbilitiesResponse>? = null,
    @SerializedName("stats")
    val stats:List<PokemonStatsResponse>? = null
) {

    fun mapToDomain(): PokemonDomain{
        return PokemonDomain(
            id = id ?: String.Empty,
            name = name ?: String.Empty,
            height = height ?: 0,
            weight = weight ?: 0,
            types = types?.map { it.mapToDomain() } ?: emptyList(),
            abilities = abilities?.map { it.mapToDomain() } ?: emptyList(),
            stats = stats?.map { it.mapToDomain() } ?: emptyList()
        )
    }
}



