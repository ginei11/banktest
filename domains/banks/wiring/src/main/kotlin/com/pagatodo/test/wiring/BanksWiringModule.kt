package com.pagatodo.test.wiring

import com.pagatodo.test.api.repository.BanksRepository
import com.pagatodo.test.api.usecases.GetBanksUC
import com.pagatodo.test.impl.infrastructure.BanksService
import com.pagatodo.test.impl.repositories.BanksRepositoryImpl
import com.pagatodo.test.impl.usecases.GetBanksUCImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BanksWiringModule {

    @Binds
    abstract fun bindBanksUc(useCase: GetBanksUCImpl): GetBanksUC

    @Binds
    abstract fun bindBanksRepository(repository: BanksRepositoryImpl): BanksRepository

    companion object {

        @Provides
        @Singleton
        fun provideBanksService(retrofit: Retrofit): BanksService {
            return retrofit.create(BanksService::class.java)
        }
    }
}
