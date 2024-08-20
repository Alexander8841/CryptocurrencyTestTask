package com.example.cryptocurrencytesttask.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencytesttask.domain.pojo.CoinDetailInfo
import com.example.cryptocurrencytesttask.domain.pojo.CoinPriceInfo
import com.example.cryptocurrencytesttask.domain.useCases.GetCurrencyListUseCase
import com.example.cryptocurrencytesttask.domain.useCases.GetDetailInfoUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CurrencyViewModel @Inject constructor(
    private val getCurrencyListUseCase: GetCurrencyListUseCase,
    private val getDetailInfoUseCase: GetDetailInfoUseCase
) : ViewModel() {

    private val _currencyList = MutableLiveData<List<CoinPriceInfo>>()
    val currencyList: LiveData<List<CoinPriceInfo>>
        get() = _currencyList

    private val _detailInfo = MutableLiveData<CoinDetailInfo>()
    val detailInfo: LiveData<CoinDetailInfo>
        get() = _detailInfo

    init {
        getCurrencyList()
    }

    fun getCurrencyList(currency: String = USD) {
        viewModelScope.launch {
            try {
                _currencyList.value = getCurrencyListUseCase(currency)
            } catch (e: Exception) {
                Log.d("data_loading", e.message.toString())
            }
        }
    }

    fun getDetailInfo(id: String) {
        viewModelScope.launch {
            try {
                _detailInfo.value = getDetailInfoUseCase(id)
            } catch (e: Exception) {
                Log.d("data_loading", e.message.toString())
            }
        }
    }

    companion object {
        private const val USD = "usd"
    }
}