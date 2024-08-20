package com.example.cryptocurrencytesttask.data.mapper

import android.content.Context
import com.example.cryptocurrencytesttask.R
import com.example.cryptocurrencytesttask.data.network.model.CoinDetailInfoDto
import com.example.cryptocurrencytesttask.data.network.model.CoinPriceInfoDto
import com.example.cryptocurrencytesttask.domain.pojo.CoinDetailInfo
import com.example.cryptocurrencytesttask.domain.pojo.CoinPriceInfo
import com.example.cryptocurrencytesttask.presentation.activities.CurrencyListActivity
import java.util.Locale
import javax.inject.Inject

class CoinMapper @Inject constructor(private val context: Context) {
    fun mapCoinPriceInfoDtoToCoinPriceInfoEntity(
        coinPriceInfoListDto: List<CoinPriceInfoDto>,
        currency: String,
    ) =
        coinPriceInfoListDto.map {
            CoinPriceInfo(
                currency,
                it.id,
                it.name,
                it.shortName.uppercase(),
                it.imageUrl,
                formattedPrice(it.price, currency),
                formattedPercent(it.priceChangePercentage)
            )
        }

    fun mapCoinDetailInfoDtoToCoinDetailInfoEntity(coinDetailInfoDto: CoinDetailInfoDto) =
        CoinDetailInfo(
            coinDetailInfoDto.name,
            coinDetailInfoDto.image.imageUrl,
            coinDetailInfoDto.description.descriptionEnglish,
            formattedCategories(coinDetailInfoDto.categories.toString())
        )

    private fun formattedCategories(categories: String) =
        if (categories.length > 2) categories.substring(
            START_LINE_INDEX,
            categories.length - LAST_INDEX
        ) else EMPTY_LINE

    private fun formattedPrice(price: Double, currency: String): String {

        val formattedPrice = "%,.2f".format(Locale.ENGLISH, price)
        val priceString = if (currency == CurrencyListActivity.USD) {
            R.string.coin_price_dollar
        } else R.string.coin_price_ruble

        return context.getString(priceString, formattedPrice)
    }

    private fun formattedPercent(percent: Double): String {
        val percentString = if (percent < 0) {
            R.string.coin_decrease
        } else R.string.price_increase

        return context.getString(percentString, kotlin.math.abs(percent))
    }

    companion object {
        private const val START_LINE_INDEX = 1
        private const val LAST_INDEX = 1
        private const val EMPTY_LINE = ""
    }
}