package com.example.cryptocurrencytesttask.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencytesttask.domain.pojo.CoinDetailInfo
import com.example.cryptocurrencytesttask.domain.pojo.CoinPriceInfo
import com.example.cryptocurrencytesttask.domain.useCases.GetCurrencyListUseCase
import com.example.cryptocurrencytesttask.domain.useCases.GetDetailInfoUseCase
import com.example.cryptocurrencytesttask.presentation.activities.CurrencyListActivity
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

    private val _successfulDownload = MutableLiveData<Boolean>()
    val successfulDownload: LiveData<Boolean>
        get() = _successfulDownload

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _refresh = MutableLiveData<Unit>()
    val refresh: LiveData<Unit>
        get() = _refresh

    private val _failRefresh = MutableLiveData<Unit>()
    val failRefresh: LiveData<Unit>
        get() = _failRefresh

    init {
        getCurrencyList()
    }

    fun getCurrencyList(currency: String = CurrencyListActivity.USD) {
        _loading.value = true
        viewModelScope.launch {
            try {
                _currencyList.value = getCurrencyListUseCase(currency)
                _successfulDownload.value = true
            } catch (e: Exception) {
                _successfulDownload.value = false
                Log.d("data_loading", e.message.toString())
            } finally {
                _loading.value = false
            }
        }
    }

    fun refreshList(currency: String = CurrencyListActivity.USD) {
        viewModelScope.launch {
            try {
                _currencyList.value = getCurrencyListUseCase(currency)
                _successfulDownload.value = true
            } catch (e: Exception) {
                _failRefresh.value = Unit
                Log.d("data_loading", e.message.toString())
            } finally {
                _refresh.value = Unit
            }
        }
    }

    fun getDetailInfo(id: String) {
        _loading.value = true
        viewModelScope.launch {
            try {
                _detailInfo.value = getDetailInfoUseCase(id)
                _successfulDownload.value = true
            } catch (e: Exception) {
                _successfulDownload.value = false
                Log.d("data_loading", e.message.toString())
            } finally {
                _loading.value = false
            }
        }
    }
}