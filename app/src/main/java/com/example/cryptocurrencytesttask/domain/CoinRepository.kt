package com.example.cryptocurrencytesttask.domain

import androidx.lifecycle.LiveData
import com.example.cryptocurrencytesttask.domain.pojo.CoinDetailInfo
import com.example.cryptocurrencytesttask.domain.pojo.CoinPriceInfo

interface CoinRepository {
    fun getCurrencyList(): LiveData<List<CoinPriceInfo>>
    fun getDetailInfo(id: String): LiveData<CoinDetailInfo>
    fun loadData(currency: String)
}