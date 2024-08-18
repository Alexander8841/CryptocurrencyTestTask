package com.example.cryptocurrencytesttask.data.repositoryImpl

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.work.WorkManager
import com.example.cryptocurrencytesttask.data.database.CurrencyDao
import com.example.cryptocurrencytesttask.data.mapper.CoinMapper
import com.example.cryptocurrencytesttask.domain.pojo.CoinDetailInfo
import com.example.cryptocurrencytesttask.domain.pojo.CoinPriceInfo
import com.example.cryptocurrencytesttask.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val mapper: CoinMapper,
    private val application: Application,
    private val currencyDao: CurrencyDao
) : CoinRepository {
    override fun getCurrencyList(): LiveData<List<CoinPriceInfo>> {
        return mapper.mapCoinPriceInfoDbModelToCoinPriceInfoEntity(currencyDao.getCurrencyList())
    }

    override fun getDetailInfo(id: String): LiveData<CoinDetailInfo> {
        return mapper.mapCoinDetailInfoDbModelToCoinDetailInfoEntity(currencyDao.getDetailInfo(id))
    }

    override fun loadData(currency: String) {
        val worker = WorkManager.getInstance(application)
        worker.enqueueUniqueWork(

        )
    }
}