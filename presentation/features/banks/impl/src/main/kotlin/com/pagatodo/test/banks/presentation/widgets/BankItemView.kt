package com.pagatodo.test.banks.presentation.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pagatodo.test.api.models.BankModel
import com.pagatodo.test.banks.impl.R
import com.pagatodo.test.designsystem.atoms.DSText
import com.pagatodo.test.designsystem.atoms.TypographyType
import com.pagatodo.test.designsystem.theme.OnBackgroundColor
import com.pagatodo.test.designsystem.utils.DesignSystemDimen
import com.pagatodo.test.organism.DSAsyncImage

@Composable
fun BankItemView(
    modifier: Modifier = Modifier,
    bank: BankModel
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        Card(
            modifier = Modifier
                .size(100.dp),
            shape = RoundedCornerShape(percent = 10),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary)
        ) {
            DSAsyncImage(
                modifier = modifier.fillMaxSize().testTag("default_image"),
                contentDescription = bank.url,
                size = dimensionResource(id = DesignSystemDimen.view_size_56),
                shape = RoundedCornerShape(dimensionResource(id = DesignSystemDimen.radius_4)),
                imageUrl = bank.url
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .height(dimensionResource(id = DesignSystemDimen.view_size_112))
                .padding(dimensionResource(id = DesignSystemDimen.spacing_2)),
            verticalArrangement = Arrangement.Center
        ) {

            DSText(text = bank.bankName, type = TypographyType.Body1, maxLines = 2)

            DSText(
                text = bank.description,
                type = TypographyType.Caption,
                maxLines = 2,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .weight(2f)
                    .fillMaxWidth()
            )

            DSText(
                text = stringResource(R.string.banks_age, bank.age),
                type = TypographyType.Caption2,
                maxLines = 1,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .weight(2f)
                    .fillMaxWidth(),
            )

        }
        Divider(
            modifier = modifier.padding(top = dimensionResource(id = DesignSystemDimen.spacing_2)),
            thickness = dimensionResource(id = DesignSystemDimen.spacing_point_five),
            color = OnBackgroundColor
        )
    }
}
