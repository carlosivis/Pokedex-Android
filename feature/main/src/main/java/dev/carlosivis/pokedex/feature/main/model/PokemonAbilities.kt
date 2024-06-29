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

    companion object {
        val mock =  PokemonAbilities(
            ability = PokemonAbility.mock,
            isHidden = false,
            slot = 1
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

    companion object {
        val mock = PokemonAbility(
            name = "mock",
            url = "example.com"
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