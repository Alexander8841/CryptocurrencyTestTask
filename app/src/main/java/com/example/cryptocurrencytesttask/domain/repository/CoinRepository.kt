package com.example.cryptocurrencytesttask.domain.repository

import androidx.lifecycle.LiveData
import com.example.cryptocurrencytesttask.domain.pojo.CoinDetailInfo
import com.example.cryptocurrencytesttask.domain.pojo.CoinPriceInfo

interface CoinRepository {
    suspend fun getCurrencyList(currency: String): LiveData<List<CoinPriceInfo>>
    suspend fun getDetailInfo(id: String): LiveData<CoinDetailInfo>
}