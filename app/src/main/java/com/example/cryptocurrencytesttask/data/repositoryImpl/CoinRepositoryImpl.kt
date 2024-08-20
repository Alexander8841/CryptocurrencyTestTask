package com.example.cryptocurrencytesttask.data.repositoryImpl

import com.example.cryptocurrencytesttask.data.mapper.CoinMapper
import com.example.cryptocurrencytesttask.data.network.api.ApiService
import com.example.cryptocurrencytesttask.domain.pojo.CoinDetailInfo
import com.example.cryptocurrencytesttask.domain.pojo.CoinPriceInfo
import com.example.cryptocurrencytesttask.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val mapper: CoinMapper,
    private val apiService: ApiService
) : CoinRepository {
    override suspend fun getCurrencyList(currency: String): List<CoinPriceInfo> {
        return mapper.mapCoinPriceInfoDtoToCoinPriceInfoEntity(apiService.getCurrencyList(currency))
    }

    override suspend fun getDetailInfo(id: String): CoinDetailInfo {
        return mapper.mapCoinDetailInfoDtoToCoinDetailInfoEntity(apiService.getDetailInfo(id))
    }
}