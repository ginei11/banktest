package com.pagatodo.test.banks.api

import com.pagatodo.test.common.navigation.AggregateFeatureEntry

interface BanksFeatureNavGraph : AggregateFeatureEntry {

    fun banksRoute(): String
}
