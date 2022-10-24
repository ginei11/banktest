package com.pagatodo.test.impl.usecases

import com.pagatodo.test.api.models.BanksUIStates
import com.pagatodo.test.api.repository.BanksRepository
import com.pagatodo.test.api.usecases.GetBanksUC
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GetBanksUCImpl @Inject constructor(private val repository: BanksRepository): GetBanksUC {

    override suspend fun invoke(): Flow<BanksUIStates> {
        return repository.getBanks().onStart {
            emit(BanksUIStates.Loading)
        }.catch {
            emit(BanksUIStates.Error(it.message.orEmpty()))
        }.flowOn(Dispatchers.IO)
    }
}
