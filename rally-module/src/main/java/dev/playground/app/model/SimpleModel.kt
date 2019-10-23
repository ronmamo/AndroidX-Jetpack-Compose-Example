package dev.playground.app.model

import androidx.compose.Model
import androidx.ui.graphics.Color

@Model
data class SimpleModel(
    val name: String,
    val value: String,
    val description: String,
    val color: Color
)
