package com.example.cryptocurrencytesttask.data.network.model

import com.google.gson.annotations.SerializedName

data class CoinDetailInfoDto (
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val imageUrl: ImageDto,
    @SerializedName("description")
    val description: DescriptionDto,
    @SerializedName("categories")
    val categories: List<String>
)