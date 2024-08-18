package com.example.cryptocurrencytesttask.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency_list")
data class CoinPriceInfoDbModel(
    @PrimaryKey
    val id: String,
    val name: String,
    val shortName: String,
    val imageUrl: String,
    val priceChangePercentage: Double
)
