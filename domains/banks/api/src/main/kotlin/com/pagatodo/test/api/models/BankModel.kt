package com.pagatodo.test.api.models

import com.google.gson.annotations.SerializedName

data class BankModel(
    @SerializedName("description") val description: String,
    @SerializedName("age") val age: String,
    @SerializedName("url") val url: String,
    @SerializedName("bankName") val bankName: String,
)
