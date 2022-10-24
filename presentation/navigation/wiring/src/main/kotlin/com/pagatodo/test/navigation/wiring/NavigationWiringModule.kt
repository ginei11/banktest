package com.pagatodo.test.navigation.wiring

import com.pagatodo.test.navigation.api.NavigationGraphRender
import com.pagatodo.test.navigation.impl.NavigationGraphRenderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigationWiringModule {

    @Binds
    abstract fun bindRenderer(renderer: NavigationGraphRenderImpl): NavigationGraphRender
}
