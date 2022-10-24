package com.pagatodo.test.impl.infrastructure.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pagatodo.test.api.models.BankModel

@Entity
data class BanksEntity(
    @PrimaryKey
    val url: String,
    val bankName: String,
    val description: String,
    val age: String,
)

fun BankModel.toBankEntity() =
    BanksEntity(
        url = this.url,
        bankName = this.bankName,
        description = this.description,
        age = this.age
    )


fun BanksEntity.toBankModel() =
    BankModel(
        description = this.description,
        age = this.age,
        url = this.url,
        bankName = this.bankName
    )
