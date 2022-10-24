package com.pagatodo.test.api.repository

import com.pagatodo.test.api.models.BanksUIStates
import kotlinx.coroutines.flow.Flow

interface BanksRepository {
    suspend fun getBanks(): Flow<BanksUIStates>
}
