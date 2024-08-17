package com.example.cryptocurrencytesttask.data.network.model

import com.google.gson.annotations.SerializedName

data class ImageDto (
    @SerializedName("large")
    val imageUrl: String
)