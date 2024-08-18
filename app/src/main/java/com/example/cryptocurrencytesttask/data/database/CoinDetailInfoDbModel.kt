package com.example.cryptocurrencytesttask.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detail_info")
data class CoinDetailInfoDbModel(
    @PrimaryKey
    val id: String,
    val name: String,
    val imageUrl: String,
    val description: String,
    val categories: String
)
