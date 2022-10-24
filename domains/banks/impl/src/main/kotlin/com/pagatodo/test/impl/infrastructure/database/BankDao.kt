package com.pagatodo.test.impl.infrastructure.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
abstract class BankDao {

    @Query("SELECT * FROM BanksEntity")
    abstract fun loadBanks(): List<BanksEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun addBanks(value: BanksEntity)
}
