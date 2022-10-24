package com.pagatodo.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.pagatodo.test.banks.api.BanksFeatureNavGraph
import com.pagatodo.test.navigation.api.NavigationGraphRender
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationGraphRender: NavigationGraphRender

    @Inject
    lateinit var banksFeatureNavGraph: BanksFeatureNavGraph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val route = banksFeatureNavGraph.banksRoute()
        navigationGraphRender.render(route)
    }
}
