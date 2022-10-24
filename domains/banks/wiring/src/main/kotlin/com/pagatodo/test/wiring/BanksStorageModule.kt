package com.pagatodo.test.wiring

import android.content.Context
import androidx.room.Room
import com.pagatodo.test.impl.infrastructure.database.BanksDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BanksStorageModule {

    @Provides
    fun provideStorage(
        @ApplicationContext context: Context
    ): BanksDatabase = Room.databaseBuilder(
        context,
        BanksDatabase::class.java,
        "paga-todo-db"
    ).build()
}
