package com.pagatodo.test.banks.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pagatodo.test.api.models.BanksUIStates
import com.pagatodo.test.api.usecases.GetBanksUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BanksViewModel @Inject constructor(
    private val getBanksUC: GetBanksUC
) : ViewModel() {

    private val _uiStates = MutableStateFlow<BanksUIStates>(BanksUIStates.Loading)
    val uiStates: StateFlow<BanksUIStates> = _uiStates

    init {
        viewModelScope.launch {
            getBanksUC().collect {
                _uiStates.value = it
            }
        }
    }
}
