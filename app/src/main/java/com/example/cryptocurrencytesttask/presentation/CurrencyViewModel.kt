package com.example.cryptocurrencytesttask.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencytesttask.domain.useCases.GetCurrencyListUseCase
import com.example.cryptocurrencytesttask.domain.useCases.GetDetailInfoUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CurrencyViewModel @Inject constructor(
    private val getCurrencyListUseCase: GetCurrencyListUseCase,
    private val getDetailInfoUseCase: GetDetailInfoUseCase,
) : ViewModel() {
    fun getCurrencyList(currency: String) =
        viewModelScope.launch{
            getCurrencyListUseCase(currency)
        }

    fun getDetailInfo(id: String) =
        viewModelScope.launch{
            getDetailInfoUseCase(id)
        }
}