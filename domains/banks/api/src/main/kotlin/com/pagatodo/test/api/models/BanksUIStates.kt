package com.pagatodo.test.api.models

sealed class BanksUIStates {
    object Loading : BanksUIStates()
    class Error(val message: String) : BanksUIStates()
    class Success(
        val banks: List<BankModel>
    ) : BanksUIStates()
}
