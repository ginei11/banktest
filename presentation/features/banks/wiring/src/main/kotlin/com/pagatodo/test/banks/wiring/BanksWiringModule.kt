package com.pagatodo.test.banks.wiring

import com.pagatodo.test.common.navigation.AggregateFeatureEntry
import com.pagatodo.test.banks.api.BanksFeatureNavGraph
import com.pagatodo.test.banks.navigation.BanksFeatureNavGraphImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class BanksWiringModule {

    @IntoSet
    @Binds
    abstract fun bindNavGraph(navGraphImpl: BanksFeatureNavGraphImpl): AggregateFeatureEntry

    @Binds
    abstract fun bindFeatureNavGraph(navGraphImpl: BanksFeatureNavGraphImpl): BanksFeatureNavGraph
}
