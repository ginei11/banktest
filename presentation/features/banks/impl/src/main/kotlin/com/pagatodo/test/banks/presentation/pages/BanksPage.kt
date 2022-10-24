package com.pagatodo.test.banks.presentation.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.pagatodo.test.api.models.BanksUIStates
import com.pagatodo.test.banks.impl.R
import com.pagatodo.test.banks.presentation.viewmodel.BanksViewModel
import com.pagatodo.test.banks.presentation.widgets.BankListContent
import com.pagatodo.test.designsystem.atoms.DSLoader
import com.pagatodo.test.organism.DSTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BanksPage(
    onBackPressed: () -> Unit,
    viewModel: BanksViewModel = hiltViewModel()
) {

    val state by viewModel.uiStates.collectAsState()
    Scaffold(
        topBar = {
            Column {
                DSTopAppBar(R.string.banks_title, onBackPressed = onBackPressed)
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            when (state) {
                BanksUIStates.Loading -> DSLoader()
                is BanksUIStates.Error -> {}
                is BanksUIStates.Success -> {
                    BankListContent(
                        modifier = Modifier.fillMaxSize(),
                        banks = (state as BanksUIStates.Success).banks
                    )
                }
            }
        }
    }
}
