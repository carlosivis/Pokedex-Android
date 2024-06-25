package dev.carlosivis.pokedex.data.remote.model

import com.google.gson.annotations.SerializedName
import dev.carlosivis.pokedex.core.commons.extension.Empty
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonStatDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonStatsDomain

internal data class PokemonStatsResponse(
    @SerializedName("stat")
    val stat:PokemonStatResponse? = null,
    @SerializedName("base_stat")
    val baseStat:Int? = null
){
    fun mapToDomain(): PokemonStatsDomain {
        return PokemonStatsDomain(
            stat = stat!!.mapToDomain(),
            baseStat = baseStat ?: 0
        )
    }
}

internal data class PokemonStatResponse(
    @SerializedName("name")
    val name:String? = null,
    @SerializedName("url")
    val url:String? = null
) {
    fun mapToDomain(): PokemonStatDomain {
        return PokemonStatDomain(
            name = name ?: String.Empty,
            url = url ?: String.Empty
        )
    }
}