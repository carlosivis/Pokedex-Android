package dev.carlosivis.pokedex.feature.main.ui.splash.draws

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp

@Composable
fun PokeBall(
    modifier: Modifier = Modifier,
    rotation: Float = 0f
) {
    Canvas(modifier = modifier.size(100.dp)) {
        drawPokeBall(rotation)
    }
}

private fun DrawScope.drawPokeBall(rotation: Float) {
    val canvasWidth = size.width
    val canvasHeight = size.height
    val centerX = canvasWidth / 2
    val centerY = canvasHeight / 2
    val radius = canvasWidth / 2

    // Red top half
    drawCircle(
        color = Color.Red,
        center = Offset(centerX, centerY),
        radius = radius
    )

    // White bottom half
    rotate(180f + rotation) {
        drawCircle(
            color = Color.White,
            center = Offset(centerX, centerY),
            radius = radius
        )
    }

    // Black dividing line
    drawLine(
        color = Color.Black,
        start = Offset(0f, centerY),
        end = Offset(canvasWidth, centerY),
        strokeWidth = 5f
    )

    // Inner white circle
    drawCircle(
        color = Color.White,
        center = Offset(centerX, centerY),
        radius = radius * 0.2f
    )

    // Black outline
    drawCircle(
        color = Color.Black,
        center = Offset(centerX, centerY),
        radius = radius,
        style = Stroke(width = 5f)
    )
}

@Composable
fun RotatingPokeBall(modifier : Modifier = Modifier) {
    var rotation by remember { mutableFloatStateOf(0f) }
    val animatedRotation by animateFloatAsState(
        targetValue = rotation,
        animationSpec = tween(durationMillis = 1000)
    )

    LaunchedEffect(key1 = Unit) {
        rotation += 360f
    }

    PokeBall(modifier = modifier, rotation = animatedRotation)
}