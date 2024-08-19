package com.example.cryptocurrencytesttask.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptocurrencytesttask.databinding.ActivityDetailInfoBinding
import com.example.cryptocurrencytesttask.domain.useCases.GetDetailInfoUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailInfoActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetailInfoBinding.inflate(layoutInflater)
    }
    @Inject
    lateinit var useCase: GetDetailInfoUseCase
    private val component by lazy {
        (application as CurrencyApp).component
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.Main).launch {
            val list = useCase("bitcoin")
            list.observe(this@DetailInfoActivity) {
                Log.d("Load", it.toString())
            }
        }
    }
}