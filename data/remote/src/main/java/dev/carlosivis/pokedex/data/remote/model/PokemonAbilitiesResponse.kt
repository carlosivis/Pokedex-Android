package dev.carlosivis.pokedex.data.remote.model

import com.google.gson.annotations.SerializedName
import dev.carlosivis.pokedex.core.commons.extension.Empty
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonAbilitiesDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonAbilityDomain

internal data class PokemonAbilitiesResponse(
    @SerializedName("ability")
    val ability:PokemonAbilityResponse? = null,
    @SerializedName("is_hidden")
    val isHidden:Boolean? = null,
    @SerializedName("slot")
    val slot:Int? = null
) {
    fun mapToDomain(): PokemonAbilitiesDomain {
        return PokemonAbilitiesDomain(
            ability = ability!!.mapToDomain(),
            isHidden = isHidden ?: false,
            slot = slot ?: 0
        )
    }
}

internal data class PokemonAbilityResponse(
    @SerializedName("name")
    val name:String? = null,
    @SerializedName("url")
    val url:String? = null
){
    fun mapToDomain(): PokemonAbilityDomain {
        return PokemonAbilityDomain(
            name = name ?: String.Empty,
            url = url ?: String.Empty
        )
    }
}
