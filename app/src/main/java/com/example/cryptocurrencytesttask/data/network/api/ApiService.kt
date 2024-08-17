package com.example.cryptocurrencytesttask.data.network.api

import com.example.cryptocurrencytesttask.data.network.model.CoinDetailInfoDto
import com.example.cryptocurrencytesttask.data.network.model.CoinPriceInfoDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("coins/markets?x_cg_demo_api_key=CG-ratezoxStMTcJJ74Vy5f5wpF")
    suspend fun getCurrencyList(@Query(CURRENCY) currency: String = "usd"): List<CoinPriceInfoDto>
    @GET("coins/{id}?x_cg_demo_api_key=CG-ratezoxStMTcJJ74Vy5f5wpF")
    suspend fun getDetailInfo(@Path(ID) id: String): CoinDetailInfoDto

    companion object {
        private const val CURRENCY = "vs_currency"
        private const val ID = "id"
    }
}