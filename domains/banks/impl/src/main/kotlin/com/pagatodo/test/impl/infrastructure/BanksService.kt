package com.pagatodo.test.impl.infrastructure

import com.pagatodo.test.api.models.BankModel
import retrofit2.Response
import retrofit2.http.GET

interface BanksService {
    @GET("catom/api/challenge/banks")
    suspend fun getBanks(): Response<List<BankModel>>
}
