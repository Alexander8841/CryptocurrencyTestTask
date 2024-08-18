package com.example.cryptocurrencytesttask.data.mapper

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.cryptocurrencytesttask.data.database.CoinDetailInfoDbModel
import com.example.cryptocurrencytesttask.data.database.CoinPriceInfoDbModel
import com.example.cryptocurrencytesttask.domain.pojo.CoinDetailInfo
import com.example.cryptocurrencytesttask.domain.pojo.CoinPriceInfo
import javax.inject.Inject

class CoinMapper @Inject constructor() {
    fun mapCoinPriceInfoDbModelToCoinPriceInfoEntity(
        coinPriceInfoListDbModel: LiveData<List<CoinPriceInfoDbModel>>
    ) =
        coinPriceInfoListDbModel.map {
            it.map {
                CoinPriceInfo(
                    it.id,
                    it.name,
                    it.shortName,
                    it.imageUrl,
                    it.priceChangePercentage
                )
            }
        }

    fun mapCoinDetailInfoDbModelToCoinDetailInfoEntity(
        coinDetailInfoDbModel: LiveData<CoinDetailInfoDbModel>
    ) =
        coinDetailInfoDbModel.map {
                CoinDetailInfo(
                    it.id,
                    it.name,
                    it.imageUrl,
                    it.description,
                    it.categories
                )
        }

    fun mapCoinPriceInfoDtoToCoinPriceInfoDbModel(
        coinPriceInfoListDto: LiveData<List<CoinPriceInfoDbModel>>
    ) =
        coinPriceInfoListDto.map {
            it.map {
                CoinPriceInfoDbModel(
                    it.id,
                    it.name,
                    it.shortName,
                    it.imageUrl,
                    it.priceChangePercentage
                )
            }
        }

    fun mapCoinDetailInfoDtoToCoinDetailInfoDbModel(
        coinDetailInfoListDto: LiveData<CoinDetailInfoDbModel>
    ) =
        coinDetailInfoListDto.map {
            CoinDetailInfoDbModel(
                it.id,
                it.name,
                it.imageUrl,
                it.description,
                it.categories
            )
        }
}