package com.pagatodo.test.banks.presentation.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.pagatodo.test.api.models.BankModel
import com.pagatodo.test.designsystem.utils.performHapticFeedback

@Composable
fun BankListContent(
    modifier: Modifier = Modifier,
    banks: List<BankModel>
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp),
    ) {
        items(items = banks) { bank ->
            BankItemView(
                modifier = Modifier.clickable {
                    context.performHapticFeedback()
                },
                bank = bank
            )
        }
    }
}
