package com.example.cryptocurrencytesttask.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptocurrencytesttask.domain.pojo.CoinPriceInfo

object CurrencyListDiffCallback : DiffUtil.ItemCallback<CoinPriceInfo>() {
    override fun areItemsTheSame(oldItem: CoinPriceInfo, newItem: CoinPriceInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CoinPriceInfo, newItem: CoinPriceInfo): Boolean {
        return oldItem == newItem
    }
}