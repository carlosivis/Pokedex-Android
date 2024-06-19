package dev.carlosivis.pokedex.feature.main.model

import android.os.Parcelable
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonAbilityDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonStatDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonTypeDomain
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonModel(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<PokemonType>,
    val abilities: List<PokemonAbility>,
    val stats: List<PokemonStat>
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
}

@Parcelize
data class PokemonType(
    val name: String,
) : Parcelable{
    fun mapToDomain(): PokemonTypeDomain {
        return PokemonTypeDomain(
            name = name
        )
    }
}

@Parcelize
data class PokemonAbility(
    val name: String,
) : Parcelable{
    fun mapToDomain(): PokemonAbilityDomain {
        return PokemonAbilityDomain(
            name = name
        )
    }
}

@Parcelize
data class PokemonStat(
    val name: String,
    val baseStat: Int,
) : Parcelable {
    fun mapToDomain(): PokemonStatDomain {
        return PokemonStatDomain(
            name = name,
            baseStat = baseStat
        )
    }

}

internal fun PokemonTypeDomain.mapToModel(): PokemonType {
    return PokemonType(
        name = name
    )
}
internal fun PokemonAbilityDomain.mapToModel(): PokemonAbility {
    return PokemonAbility(
        name = name
    )
}
internal fun PokemonStatDomain.mapToModel(): PokemonStat {
    return PokemonStat(
        name = name,
        baseStat = baseStat
    )
}

internal fun PokemonDomain.mapToModel(): PokemonModel{
    return PokemonModel(
        id = id,
        name = name,
        height = height,
        weight = weight,
        types = types.map { it.mapToModel() },
        abilities = abilities.map{ it.mapToModel() },
        stats = stats.map { it.mapToModel() }
    )
}