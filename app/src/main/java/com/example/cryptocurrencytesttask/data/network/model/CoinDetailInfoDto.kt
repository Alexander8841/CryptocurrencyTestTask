package com.example.cryptocurrencytesttask.data.network.model

import com.google.gson.annotations.SerializedName

data class CoinDetailInfoDto (
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: ImageDto,
    @SerializedName("description")
    val description: DescriptionDto,
    @SerializedName("categories")
    val categories: List<String>
)