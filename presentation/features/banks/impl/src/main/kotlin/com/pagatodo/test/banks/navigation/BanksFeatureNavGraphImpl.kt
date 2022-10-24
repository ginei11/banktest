package com.pagatodo.test.banks.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.pagatodo.test.banks.api.BanksFeatureNavGraph
import com.pagatodo.test.banks.presentation.pages.BanksPage
import javax.inject.Inject

class BanksFeatureNavGraphImpl @Inject constructor() : BanksFeatureNavGraph {

    override fun banksRoute(): String = "banks"

    override fun registerNavigation(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(banksRoute()) {
            BanksPage(onBackPressed = {
                navController.popBackStack()
            })
        }
    }
}
