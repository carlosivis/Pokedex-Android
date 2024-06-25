import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PokeballLoadingAnimation(isLoading: Boolean) {
    if (isLoading) {
        val infiniteTransition = rememberInfiniteTransition()
        val rotation by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Canvas(
                modifier = Modifier
                    .size(164.dp)
                    .rotate(rotation)
            ) {
                val canvasWidth = size.width
                val canvasHeight = size.height

                // Draw the top half (red)
                drawArc(
                    color = Color.Red,
                    startAngle = 180f,
                    sweepAngle = 180f,
                    useCenter = true,
                    topLeft = Offset.Zero,
                    size = size
                )

                // Draw the bottom half (white)
                drawArc(
                    color = Color.White,
                    startAngle = 0f,
                    sweepAngle = 180f,
                    useCenter = true,
                    topLeft = Offset.Zero,
                    size = size
                )

                // Draw the center black line
                drawLine(
                    color = Color.Black,
                    start = Offset(0f, canvasHeight / 2),
                    end = Offset(canvasWidth, canvasHeight / 2),
                    strokeWidth = 4.dp.toPx()
                )

                // Draw the outer circle in the center
                drawCircle(
                    color = Color.Black,
                    radius = canvasWidth / 6,
                    center = Offset(canvasWidth / 2, canvasHeight / 2)
                )

                // Draw the inner white circle in the center
                drawCircle(
                    color = Color.White,
                    radius = canvasWidth / 10,
                    center = Offset(canvasWidth / 2, canvasHeight / 2)
                )
            }
        }
    }
}
