package com.example.cryptocurrencytesttask.domain.pojo

data class CurrencyList(
    val id: String,
    val name: String,
    val shortName: String,
    val imageUrl: String,
    val priceChangePercentage: Double
)
