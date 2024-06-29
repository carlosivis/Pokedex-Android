package dev.carlosivis.pokedex.feature.main.model

import android.os.Parcelable
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonTypeDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonTypesDomain
import kotlinx.parcelize.Parcelize


@Parcelize
data class PokemonTypes(
    val slot: Int,
    val type: PokemonType
) : Parcelable{
    fun mapToDomain(): PokemonTypesDomain {
        return PokemonTypesDomain(
            slot = slot,
            type = type.mapToDomain()
        )
    }

    companion object {
        val mock = PokemonTypes(
            slot = 1,
            type = PokemonType.mock
        )
    }

}

@Parcelize
data class PokemonType(
    val name: String,
    val url: String
) : Parcelable {
    fun mapToDomain(): PokemonTypeDomain {
        return PokemonTypeDomain(
            name = name,
            url = url
        )
    }
    companion object {
        val mock = PokemonType(
            name = "grass",
            url = "example.com"
        )
    }
}
internal fun PokemonTypeDomain.mapToModel(): PokemonType {
    return PokemonType(
        name = name,
        url = url
    )
}
internal fun PokemonTypesDomain.mapToModel(): PokemonTypes {
    return PokemonTypes(
        slot = slot,
        type = type.mapToModel()
    )
}
