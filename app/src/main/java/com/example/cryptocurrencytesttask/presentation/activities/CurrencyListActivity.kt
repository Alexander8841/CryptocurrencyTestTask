package com.example.cryptocurrencytesttask.presentation.activities

import android.os.Bundle
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cryptocurrencytesttask.databinding.ActivityCurrencyListBinding
import com.example.cryptocurrencytesttask.presentation.CurrencyApp
import com.example.cryptocurrencytesttask.presentation.adapters.CurrencyListAdapter
import com.example.cryptocurrencytesttask.presentation.viewModels.CurrencyViewModel
import com.example.cryptocurrencytesttask.presentation.viewModels.ViewModelFactory
import javax.inject.Inject

class CurrencyListActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityCurrencyListBinding.inflate(layoutInflater)
    }
    private val component by lazy {
        (application as CurrencyApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CurrencyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvCurrencyList.visibility = VISIBLE

        val adapter = CurrencyListAdapter(this)
        adapter.onClickListener = {
            startActivity(DetailInfoActivity.newIntent(this, it.id))
        }
        binding.rvCurrencyList.adapter = adapter
        viewModel.currencyList.observe(this) {
            adapter.submitList(it) }
    }
}