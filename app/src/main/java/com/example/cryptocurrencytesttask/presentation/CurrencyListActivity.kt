package com.example.cryptocurrencytesttask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cryptocurrencytesttask.R
import com.example.cryptocurrencytesttask.data.network.api.ApiFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CurrencyListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_list)


        CoroutineScope(Dispatchers.Main).launch {
            val info = ApiFactory.apiService.getCurrencyList("usd")
            Log.d("Main", info.toString())
        }
    }
}