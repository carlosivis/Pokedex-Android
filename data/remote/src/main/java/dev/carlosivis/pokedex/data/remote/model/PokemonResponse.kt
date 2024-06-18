package dev.carlosivis.pokedex.data.remote.model

import com.google.gson.annotations.SerializedName
import dev.carlosivis.pokedex.core.commons.extension.Empty
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonAbilityDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonStatDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonTypeDomain

internal data class PokemonResponse(
    @SerializedName("id")
    val id:Int? = null,
    @SerializedName("name")
    val name:String? = null,
    @SerializedName("height")
    val height:Int? = null,
    @SerializedName("weight")
    val weight:Int? = null,
    @SerializedName("types")
    val types:List<PokemonTypeResponse>? = null,
    @SerializedName("abilities")
    val abilities:List<PokemonAbilityResponse>? = null,
    @SerializedName("stats")
    val stats:List<PokemonStatResponse>? = null
) {

    fun mapToDomain(): PokemonDomain{
        return PokemonDomain(
            id = id ?: 0,
            name = name ?: String.Empty,
            height = height ?: 0,
            weight = weight ?: 0,
            types = types?.map { it.mapToDomain() } ?: emptyList(),
            abilities = abilities?.map { it.mapToDomain() } ?: emptyList(),
            stats = stats?.map { it.mapToDomain() } ?: emptyList()
        )
    }
}

internal data class PokemonTypeResponse(
    @SerializedName("type")
    val name:String? = null
) {
    fun mapToDomain(): PokemonTypeDomain {
        return PokemonTypeDomain(
            name = name ?: String.Empty
        )
    }
}

internal data class PokemonAbilityResponse(
    @SerializedName("name")
    val name:String? = null
) {
    fun mapToDomain(): PokemonAbilityDomain {
        return PokemonAbilityDomain(
            name = name ?: String.Empty
        )
    }
}

internal data class PokemonStatResponse(
    @SerializedName("stat")
    val name:String? = null,
    @SerializedName("baseStat")
    val baseStat:Int? = null
){
    fun mapToDomain(): PokemonStatDomain {
        return PokemonStatDomain(
            name = name ?: String.Empty,
            baseStat = baseStat ?: 0
        )

    }
}