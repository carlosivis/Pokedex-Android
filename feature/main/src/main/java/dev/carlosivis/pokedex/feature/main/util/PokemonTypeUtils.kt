package dev.carlosivis.pokedex.feature.main.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.carlosivis.pokedex.core.uikit.theme.Colors


@Composable
fun getTypeColor(type: String): Color {
    return when (type) {
            "fighting" -> Colors.fighting
            "flying" -> Colors.flying
            "poison" -> Colors.poison
            "ground" -> Colors.ground
            "rock" -> Colors.rock
            "bug" -> Colors.bug
            "ghost" -> Colors.ghost
            "steel" -> Colors.steel
            "fire" -> Colors.fire
            "water" -> Colors.water
            "grass" -> Colors.grass
            "electric" -> Colors.electric
            "psychic" -> Colors.psychic
            "ice" -> Colors.ice
            "dragon" -> Colors.dragon
            "fairy" -> Colors.fairy
            "dark" -> Colors.dark
            else -> Color.Gray
        }
    }