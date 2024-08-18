package com.example.cryptocurrencytesttask.di

import com.example.cryptocurrencytesttask.data.repositoryImpl.CoinRepositoryImpl
import com.example.cryptocurrencytesttask.domain.repository.CoinRepository
import com.example.cryptocurrencytesttask.presentation.CurrencyApp
import com.example.cryptocurrencytesttask.presentation.CurrencyListActivity
import com.example.cryptocurrencytesttask.presentation.DetailInfoActivity
import dagger.Binds
import dagger.Component

@Component(modules = [DataModule::class])
interface ApplicationComponent {
    fun inject(activity: CurrencyListActivity)
    fun inject(activity: DetailInfoActivity)
    fun inject(application: CurrencyApp)
}