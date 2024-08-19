package com.example.cryptocurrencytesttask.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptocurrencytesttask.R
import com.example.cryptocurrencytesttask.databinding.ActivityCurrencyListBinding
import com.example.cryptocurrencytesttask.domain.useCases.GetCurrencyListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CurrencyListActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityCurrencyListBinding.inflate(layoutInflater)
    }
    @Inject
    lateinit var useCase: GetCurrencyListUseCase
    private val component by lazy {
        (application as CurrencyApp).component
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.Main).launch {
            val list = useCase("usd")
            list.observe(this@CurrencyListActivity) {
                Log.d("Load", it.toString())
            }
        }
    }
}