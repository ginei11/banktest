package com.pagatodo.test.api.usecases

import com.pagatodo.test.api.models.BanksUIStates
import kotlinx.coroutines.flow.Flow

interface GetBanksUC {
    suspend operator fun invoke(): Flow<BanksUIStates>
}
