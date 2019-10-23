package dev.playground.app.components

import androidx.animation.CubicBezierEasing
import androidx.animation.FloatPropKey
import androidx.animation.LinearOutSlowInEasing
import androidx.animation.transitionDefinition
import androidx.compose.Composable
import androidx.compose.memo
import androidx.compose.unaryPlus
import androidx.ui.animation.Transition
import androidx.ui.core.Draw
import androidx.ui.core.dp
import androidx.ui.core.minDimension
import androidx.ui.engine.geometry.Rect
import androidx.ui.graphics.Color
import androidx.ui.graphics.Paint
import androidx.ui.graphics.PaintingStyle

private const val DividerLengthInDegrees = 1.8f
private val AngleOffset = FloatPropKey()
private val Shift = FloatPropKey()

private val CircularTransition = transitionDefinition {
    state(0) {
        this[AngleOffset] = 0f
        this[Shift] = 0f
    }
    state(1) {
        this[AngleOffset] = 360f
        this[Shift] = 30f
    }
    transition(fromState = 0, toState = 1) {
        AngleOffset using tween {
            delay = 500
            duration = 900
            easing = CubicBezierEasing(0f, 0.75f, 0.35f, 0.85f)
        }
        Shift using tween {
            delay = 500
            duration = 900
            easing = LinearOutSlowInEasing
        }
    }
}

/** when calculating a proportion of N elements, the sum of elements has to be (1 - N * 0.005)
 * because there will be N dividers of size 1.8 degrees */
@Composable
fun DrawAnimatedCircle(proportions: List<Float>, colors: List<Color>) {
    val strokeWidthDp = 5.dp
    val paint = +memo { Paint() }
    Transition(definition = CircularTransition, toState = 1) { state ->
        Draw { canvas, parentSize ->
            val strokeWidth = strokeWidthDp.toPx().value
            paint.style = PaintingStyle.stroke
            paint.strokeWidth = strokeWidth
            paint.isAntiAlias = true

            val innerRadius = (parentSize.minDimension.value - strokeWidth) / 2
            val parentHalfWidth = parentSize.width.value / 2
            val parentHalfHeight = parentSize.height.value / 2
            val rect = Rect(
                parentHalfWidth - innerRadius,
                parentHalfHeight - innerRadius,
                parentHalfWidth + innerRadius,
                parentHalfHeight + innerRadius
            )
            var startAngle = state[Shift] - 90f
            proportions.forEachIndexed { index, proportion ->
                paint.color = colors[index]
                val sweep = proportion * state[AngleOffset]
                canvas.drawArc(rect, startAngle, sweep, false, paint = paint)
                startAngle += sweep + DividerLengthInDegrees
            }
        }
    }
}