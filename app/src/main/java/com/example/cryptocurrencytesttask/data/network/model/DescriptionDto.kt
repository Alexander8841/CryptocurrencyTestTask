package com.example.cryptocurrencytesttask.data.network.model

import com.google.gson.annotations.SerializedName

data class DescriptionDto (
    @SerializedName("en")
    val descriptionEnglish: String
)