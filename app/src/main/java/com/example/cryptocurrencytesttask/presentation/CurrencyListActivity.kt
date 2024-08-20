package com.example.cryptocurrencytesttask.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptocurrencytesttask.databinding.ActivityCurrencyListBinding
import javax.inject.Inject

class CurrencyListActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityCurrencyListBinding.inflate(layoutInflater)
    }
    private val component by lazy {
        (application as CurrencyApp).component
    }
    @Inject
    lateinit var viewModel: CurrencyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.getCurrencyList("asd")

    }
}