package com.example.cryptocurrencytesttask.domain.repository

import com.example.cryptocurrencytesttask.domain.pojo.CoinDetailInfo
import com.example.cryptocurrencytesttask.domain.pojo.CoinPriceInfo

interface CoinRepository {
    suspend fun getCurrencyList(currency: String): List<CoinPriceInfo>
    suspend fun getDetailInfo(id: String): CoinDetailInfo
}