package com.example.cryptocurrencytesttask.presentation

import android.app.Application
import com.example.cryptocurrencytesttask.di.DaggerApplicationComponent

class CurrencyApp : Application() {
    private val component by lazy {
        DaggerApplicationComponent.create()
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}