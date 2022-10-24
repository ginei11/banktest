package com.pagatodo.test.designsystem.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.pagatodo.test.designsystem.theme.OnTertiaryColor

@Composable
fun DSLoader(
    modifier: Modifier = Modifier,
    alpha: Float = 0.8f,
    backgroundColor: Color = Color.White
) {
    Box(
        modifier = modifier
            .clickable(false) { /* Nothing */ }
            .fillMaxSize()
            .background(backgroundColor.copy(alpha = alpha)),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = OnTertiaryColor,
            strokeWidth = dimensionResource(R.dimen.radius_2)
        )
    }
}
