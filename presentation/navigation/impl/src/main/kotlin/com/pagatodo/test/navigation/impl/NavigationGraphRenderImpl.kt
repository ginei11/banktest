package com.pagatodo.test.navigation.impl

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pagatodo.test.common.navigation.FeatureNavGraphs
import com.pagatodo.test.designsystem.theme.ApplicationTheme
import com.pagatodo.test.navigation.api.NavigationGraphRender
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class NavigationGraphRenderImpl @Inject constructor(
    private val activity: Activity,
    private val destinations: FeatureNavGraphs
) : NavigationGraphRender {
    override fun render(startDestination: String) {
        (activity as ComponentActivity).setContent {
            ApplicationTheme {
                AppNavigationGraph(startDestination = startDestination, destinations = destinations)
            }
        }
    }
}
