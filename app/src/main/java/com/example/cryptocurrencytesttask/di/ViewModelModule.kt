package com.example.cryptocurrencytesttask.di

import androidx.lifecycle.ViewModel
import com.example.cryptocurrencytesttask.presentation.viewModels.CurrencyViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CurrencyViewModel::class)
    fun bindViewModel(viewModel: CurrencyViewModel): ViewModel
}