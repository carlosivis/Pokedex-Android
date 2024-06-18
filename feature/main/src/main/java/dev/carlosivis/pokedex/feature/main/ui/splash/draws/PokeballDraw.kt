package dev.carlosivis.pokedex.feature.main.ui.splash.draws

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Pokeball() {
    val sizedp = 300.dp
    val sizepx = with(LocalDensity.current) { sizedp.toPx() }
    Box(
        modifier = Modifier
            .padding(32.dp)
            .wrapContentSize()
    ) {
        val blackLineColor = Color.Black
        val strokeWidth = sizepx * .04f
        val outterBallPercentage = .25.toFloat()
        val innerBallPercentage = .17.toFloat()
        val innerestBallPercentage = .10.toFloat()
        Box(
            modifier = Modifier
                .width(sizedp)
                .height(sizedp)
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                drawArc(
                    brush = Brush.linearGradient(listOf(Color.White, Color.White)),
                    startAngle = 0f,
                    sweepAngle = 180f, // * animateFloat.value,
                    useCenter = false
                )
                drawArc(
                    brush = Brush.linearGradient(listOf(Color.Red, Color.Red)),
                    startAngle = 180f,
                    sweepAngle = 180f, // * animateFloat.value,
                    useCenter = false
                )
                drawArc(
                    color = blackLineColor,
                    startAngle = 0f,
                    sweepAngle = 360f, // * animateFloat.value,
                    useCenter = false,
                    style = Stroke(strokeWidth)
                )

                drawLine(
                    color = blackLineColor,
                    start = Offset(
                        x = 0f,
                        y = (size.height / 2)
                    ),
                    end = Offset(
                        x = size.width,
                        y = (size.height / 2)
                    ),
                    strokeWidth = strokeWidth

                )
                val outterBallSizePx = sizepx * outterBallPercentage
                drawCircle(
                    color = Color.Black,
                    radius = outterBallSizePx / 2,
                )

                val innerBallSizePx = sizepx * innerBallPercentage
                drawCircle(
                    color = Color.White,
                    radius = innerBallSizePx / 2,
                )

                val innerestBallSizePx = sizepx * innerestBallPercentage
                val innerestBallMarginPx = ((sizepx - innerestBallSizePx) / 2)
                drawArc(
                    color = Color.LightGray,
                    startAngle = 0f,
                    sweepAngle = 360f, // * animateFloat.value,
                    useCenter = false,
                    topLeft = Offset(
                        x = innerestBallMarginPx,
                        y = innerestBallMarginPx,
                    ),
                    size = Size(
                        width = innerestBallSizePx,
                        height = innerestBallSizePx,
                    ),
                    style = Stroke(4f)
                )

            }
        }
    }
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

    Pokeball()
}