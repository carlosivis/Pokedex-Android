package dev.carlosivis.pokedex.feature.main.model

import android.os.Parcelable
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonStatDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonStatsDomain
import kotlinx.parcelize.Parcelize


@Parcelize
data class PokemonStats(
    val stat: PokemonStat,
    val baseStat: Int,
): Parcelable {
    fun mapToDomain(): PokemonStatsDomain {
        return PokemonStatsDomain(
            stat = stat.mapToDomain(),
            baseStat = baseStat
        )
    }
}
@Parcelize
data class PokemonStat(
    val name: String,
    val url: String,
) : Parcelable {
    fun mapToDomain(): PokemonStatDomain {
        return PokemonStatDomain(
            name = name,
            url = url
        )
    }

}


internal fun PokemonStatsDomain.mapToModel(): PokemonStats {
    return PokemonStats(
        stat = stat.mapToModel(),
        baseStat = baseStat
    )
}

internal fun PokemonStatDomain.mapToModel(): PokemonStat {
    return PokemonStat(
        name = name,
        url = url
    )
}