package com.pagatodo.test.impl.repositories

import android.util.Log
import com.pagatodo.test.api.models.BanksUIStates
import com.pagatodo.test.api.repository.BanksRepository
import com.pagatodo.test.impl.infrastructure.BanksService
import com.pagatodo.test.impl.infrastructure.database.BanksDatabase
import com.pagatodo.test.impl.infrastructure.database.toBankEntity
import com.pagatodo.test.impl.infrastructure.database.toBankModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BanksRepositoryImpl @Inject constructor(
    private val service: BanksService,
    private val banksDatabase: BanksDatabase
) : BanksRepository {

    override suspend fun getBanks(): Flow<BanksUIStates> {
        return flow {
            val banksCache = banksDatabase.bankDao().loadBanks()
            if (banksCache.isNotEmpty()) {
                emit(BanksUIStates.Success(banksCache.map { it.toBankModel() }))
            } else {
                val response = service.getBanks()
                if (response.isSuccessful) {
                    response.body()?.let {
                        it.forEach {
                            banksDatabase.bankDao().addBanks(
                                it.toBankEntity()
                            )
                        }
                        emit(BanksUIStates.Success(it))
                    }
                } else {
                    emit(BanksUIStates.Error(response.message()))
                }
            }
        }
    }
}
