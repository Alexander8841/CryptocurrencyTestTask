package com.example.cryptocurrencytesttask.domain.pojo

data class CoinPriceInfo(
    val id: String,
    val name: String,
    val shortName: String,
    val imageUrl: String,
    val priceChangePercentage: Double
)
