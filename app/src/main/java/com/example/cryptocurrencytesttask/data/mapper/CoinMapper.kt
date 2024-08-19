package com.example.cryptocurrencytesttask.data.mapper

import com.example.cryptocurrencytesttask.data.network.model.CoinDetailInfoDto
import com.example.cryptocurrencytesttask.data.network.model.CoinPriceInfoDto
import com.example.cryptocurrencytesttask.domain.pojo.CoinDetailInfo
import com.example.cryptocurrencytesttask.domain.pojo.CoinPriceInfo
import javax.inject.Inject

class CoinMapper @Inject constructor() {
    fun mapCoinPriceInfoDtoToCoinPriceInfoEntity(coinPriceInfoListDto: List<CoinPriceInfoDto>) =
        coinPriceInfoListDto.map {
            CoinPriceInfo(
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
            coinDetailInfoDto.id,
            coinDetailInfoDto.name,
            coinDetailInfoDto.image.imageUrl,
            coinDetailInfoDto.description.descriptionEnglish,
            coinDetailInfoDto.categories.toString()
        )
}