package com.example.cryptocurrencytesttask.data.network.model

import com.google.gson.annotations.SerializedName

data class CoinPriceInfoDto (
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val shortName: String,
    @SerializedName("image")
    val imageUrl: String,
    @SerializedName("price_change_percentage_24h")
    val priceChangePercentage: Double
)