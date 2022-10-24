package com.pagatodo.test.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.pagatodo.test.designsystem.theme.DarkColorPalette
import com.pagatodo.test.designsystem.theme.LightColorPalette
import com.pagatodo.test.designsystem.theme.Shapes
import com.pagatodo.test.designsystem.theme.Typography

@Composable
fun ApplicationTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
