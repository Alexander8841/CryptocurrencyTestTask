package com.example.cryptocurrencytesttask.data.mapper

import com.example.cryptocurrencytesttask.data.network.model.CoinDetailInfoDto
import com.example.cryptocurrencytesttask.data.network.model.CoinPriceInfoDto
import com.example.cryptocurrencytesttask.domain.pojo.CoinDetailInfo
import com.example.cryptocurrencytesttask.domain.pojo.CoinPriceInfo
import javax.inject.Inject

class CoinMapper @Inject constructor() {
    fun mapCoinPriceInfoDtoToCoinPriceInfoEntity(
        coinPriceInfoListDto: List<CoinPriceInfoDto>,
        currency: String
    ) =
        coinPriceInfoListDto.map {
            CoinPriceInfo(
                currency,
                it.id,
                it.name,
                it.shortName,
                it.imageUrl,
                it.price,
                it.priceChangePercentage
            )
        }

    fun mapCoinDetailInfoDtoToCoinDetailInfoEntity(coinDetailInfoDto: CoinDetailInfoDto) =
        CoinDetailInfo(
            coinDetailInfoDto.name,
            coinDetailInfoDto.image.imageUrl,
            coinDetailInfoDto.description.descriptionEnglish,
            coinDetailInfoDto.categories.toString().substring(
                START_LINE_INDEX,
                getEndLineIndex(coinDetailInfoDto)
            )
        )

    companion object {
        private const val START_LINE_INDEX = 1
        fun getEndLineIndex(coinDetailInfoDto: CoinDetailInfoDto) =
            coinDetailInfoDto.categories.toString().length - 1
    }
}