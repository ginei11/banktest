package com.pagatodo.test.impl.infrastructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        BanksEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(BanksConverter::class)
abstract class BanksDatabase : RoomDatabase() {

    /**
     * List banks
     */
    abstract fun bankDao(): BankDao
}
