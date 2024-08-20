package com.example.cryptocurrencytesttask.domain.pojo

data class CoinPriceInfo(
    val currency: String,
    val id: String,
    val name: String,
    val shortName: String,
    val imageUrl: String,
    val price: Double,
    val priceChangePercentage: Double
)
