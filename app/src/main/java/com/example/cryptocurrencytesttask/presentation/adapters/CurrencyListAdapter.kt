package com.example.cryptocurrencytesttask.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cryptocurrencytesttask.R
import com.example.cryptocurrencytesttask.databinding.CoinItemBinding
import com.example.cryptocurrencytesttask.domain.pojo.CoinPriceInfo
import com.squareup.picasso.Picasso

class CurrencyListAdapter(
    private val context: Context
) : ListAdapter<CoinPriceInfo, CurrencyViewHolder>(CurrencyListDiffCallback) {

    private lateinit var binding: CoinItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        binding = CoinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyViewHolder(binding)
    }

    var onClickListener: ((CoinPriceInfo) -> Unit)? = null

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currencyInfo = getItem(position)
        with(holder.binding) {
            Picasso.get().load(currencyInfo.imageUrl).into(ivLogo)
            tvCoinName.text = currencyInfo.name
            tvCoinShortName.text = currencyInfo.shortName
            tvPrice.text = currencyInfo.price

            val percent = currencyInfo.priceChangePercentage
            val color = if (percent[0] == '+') R.color.green else R.color.red
            tvPriceChangePercentage.text = percent
            tvPriceChangePercentage.setTextColor(context.getColor(color))

            root.setOnClickListener { onClickListener?.invoke(currencyInfo) }
        }
    }
}