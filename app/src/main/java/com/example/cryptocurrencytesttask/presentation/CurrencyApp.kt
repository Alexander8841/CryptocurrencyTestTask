package com.example.cryptocurrencytesttask.presentation

import android.app.Application
import com.example.cryptocurrencytesttask.di.ApplicationComponent
import com.example.cryptocurrencytesttask.di.DaggerApplicationComponent

class CurrencyApp : Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}