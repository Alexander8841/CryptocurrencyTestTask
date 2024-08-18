package com.example.cryptocurrencytesttask.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM currency_list")
    fun getCurrencyList(): LiveData<List<CoinPriceInfoDbModel>>
    @Query("SELECT * FROM detail_info WHERE id == :id LIMIT 1")
    fun getDetailInfo(id: String): LiveData<List<CoinDetailInfoDbModel>>
}