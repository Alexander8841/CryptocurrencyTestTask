package com.example.cryptocurrencytesttask.di

import android.content.Context
import com.example.cryptocurrencytesttask.presentation.CurrencyApp
import com.example.cryptocurrencytesttask.presentation.activities.CurrencyListActivity
import com.example.cryptocurrencytesttask.presentation.activities.DetailInfoActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(activity: CurrencyListActivity)
    fun inject(activity: DetailInfoActivity)
    fun inject(application: CurrencyApp)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}