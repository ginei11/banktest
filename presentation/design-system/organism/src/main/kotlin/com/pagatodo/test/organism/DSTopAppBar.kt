package com.pagatodo.test.organism

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.pagatodo.test.designsystem.atoms.DSText
import com.pagatodo.test.designsystem.atoms.TypographyType
import com.pagatodo.test.designsystem.theme.blueColor
import com.pagatodo.test.designsystem.utils.DesignSystemDimen

@Composable
fun DSTopAppBar(banksTitle: Int, onBackPressed: () -> Unit) {
    TopAppBar(
        title = {
            DSText(
                modifier = Modifier.testTag("app_bar_title"),
                text = stringResource(banksTitle),
                color = Color.White,
                type = TypographyType.H5,
                maxLines = 1
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackPressed, modifier = Modifier.testTag("app_bar_icon")) {
                Icon(
                    Icons.Filled.ArrowBack, null
                )
            }
        },
        backgroundColor = blueColor,
        contentColor = Color.Black,
        elevation = dimensionResource(id = DesignSystemDimen.elevation_3)
    )
}
