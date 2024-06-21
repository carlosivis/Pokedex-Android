package dev.carlosivis.pokedex.feature.main.model

import android.os.Parcelable
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonAbilitiesDomain
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonAbilityDomain
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonAbilities(
    val ability: PokemonAbility,
    val isHidden: Boolean,
    val slot: Int
): Parcelable{
    fun mapToDomain(): PokemonAbilitiesDomain {
        return PokemonAbilitiesDomain(
            ability = ability.mapToDomain(),
            isHidden = isHidden,
            slot = slot
        )
    }
}

@Parcelize
data class PokemonAbility(
    val name: String,
    val url: String
): Parcelable{
    fun mapToDomain(): PokemonAbilityDomain {
        return PokemonAbilityDomain(
            name = name,
            url = url
        )
    }
}

internal fun PokemonAbilityDomain.mapToModel(): PokemonAbility {
    return PokemonAbility(
        name = name,
        url = url
    )
}

internal fun PokemonAbilitiesDomain.mapToModel(): PokemonAbilities {
    return PokemonAbilities(
        ability = ability.mapToModel(),
        isHidden = isHidden,
        slot = slot
    )
}