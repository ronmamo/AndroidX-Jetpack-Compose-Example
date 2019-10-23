package dev.playground.app.style

import androidx.compose.Composable
import androidx.ui.core.sp
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialColors
import androidx.ui.material.MaterialTheme
import androidx.ui.material.MaterialTypography
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontWeight


val rallyGreen = Color(0xFF1EB980)
val rallyDarkGreen = Color(0xFF045D56)
val rallyOrange = Color(0xFFFF6859)
val rallyYellow = Color(0xFFFFCF44)
val rallyPurple = Color(0xFFB15DFF)
val rallyBlue = Color(0xFF72DEFF)

val colorSet1 = listOf(0xFF1EB980, 0xFF005D57, 0xFF04B97F, 0xFF37EFBA, 0xFFFAFFBF).map { Color(it) }

val colorSet2 = listOf(
    rallyGreen,
    rallyDarkGreen,
    rallyOrange,
    rallyYellow,
    rallyPurple,
    rallyBlue
)

val materialColors = MaterialColors(
    primary = rallyGreen,
    surface = Color(0xFF33333D),
    onSurface = Color.White,
    background = Color(0xFF26282F),
    onBackground = Color.White
)

val materialTypography = MaterialTypography(
    h1 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
        fontWeight = FontWeight.w100,
        fontSize = 96.sp),
    h2 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
        fontWeight = FontWeight.w100,
        fontSize = 60.sp),
    h3 = TextStyle(fontFamily = FontFamily("Eczar"),
        fontWeight = FontWeight.w500,
        fontSize = 48.sp),
    h4 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
        fontWeight = FontWeight.w700,
        fontSize = 34.sp),
    h5 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
        fontWeight = FontWeight.w700,
        fontSize = 24.sp),
    h6 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
        fontWeight = FontWeight.w700,
        fontSize = 20.sp),
    subtitle1 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
        fontWeight = FontWeight.w700,
        fontSize = 16.sp),
    subtitle2 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
        fontWeight = FontWeight.w500,
        fontSize = 14.sp),
    body1 = TextStyle(fontFamily = FontFamily("Eczar"),
        fontWeight = FontWeight.w700,
        fontSize = 16.sp),
    body2 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
        fontWeight = FontWeight.w200,
        fontSize = 14.sp),
    button = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
        fontWeight = FontWeight.w800,
        fontSize = 14.sp),
    caption = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
        fontWeight = FontWeight.w500,
        fontSize = 12.sp),
    overline = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
        fontWeight = FontWeight.w500,
        fontSize = 10.sp)
)

@Composable
fun RallyTheme(children: @Composable() () -> Unit) {
    MaterialTheme(colors = materialColors, typography = materialTypography) {
        children()
    }
}