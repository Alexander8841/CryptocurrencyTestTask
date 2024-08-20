package com.example.cryptocurrencytesttask.presentation

import android.app.Application
import com.example.cryptocurrencytesttask.di.ApplicationComponent
import com.example.cryptocurrencytesttask.di.ApplicationScope
import com.example.cryptocurrencytesttask.di.DaggerApplicationComponent

@ApplicationScope
class CurrencyApp : Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.create()
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}