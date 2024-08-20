package com.example.cryptocurrencytesttask.di

import com.example.cryptocurrencytesttask.data.network.api.ApiFactory
import com.example.cryptocurrencytesttask.data.repositoryImpl.CoinRepositoryImpl
import com.example.cryptocurrencytesttask.domain.repository.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    @Binds
    @ApplicationScope
    fun bindRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {
        @Provides
        @ApplicationScope
        fun provideApiService() = ApiFactory.apiService
    }
}