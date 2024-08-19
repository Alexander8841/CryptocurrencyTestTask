package com.example.cryptocurrencytesttask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cryptocurrencytesttask.R
import com.example.cryptocurrencytesttask.databinding.ActivityCurrencyListBinding
import com.example.cryptocurrencytesttask.databinding.ActivityDetailInfoBinding

class DetailInfoActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetailInfoBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}