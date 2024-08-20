package com.example.cryptocurrencytesttask.presentation.activities

import android.os.Bundle
import android.view.Gravity
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cryptocurrencytesttask.R
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
    private val adapter = CurrencyListAdapter(this)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CurrencyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvCurrencyList.adapter = adapter
        adapter.onClickListener = {
            startActivity(DetailInfoActivity.newIntent(this, it.id))
        }
        observeViewModel()
        setListeners()
    }

    private fun setListeners() {
        binding.cgCurrencyChoice.setOnCheckedStateChangeListener { _, checkedIds ->
            if (checkedIds.isNotEmpty()) {
                binding.rvCurrencyList.visibility = GONE
                binding.llError.visibility = GONE
                when (checkedIds[0]) {
                    R.id.chipUsd -> viewModel.getCurrencyList(USD)
                    R.id.chipRub -> viewModel.getCurrencyList(RUB)
                }
            }
        }
        binding.buttonTryAgain.setOnClickListener {
            var id = RUB
            if (!binding.chipRub.isChecked) {
                id = USD
                binding.cgCurrencyChoice.check(R.id.chipUsd)
            }
            viewModel.getCurrencyList(id)
            binding.llError.visibility = GONE
        }
        binding.swipeRefresh.setOnRefreshListener {
            var id = RUB
            if (!binding.chipRub.isChecked) {
                id = USD
                binding.cgCurrencyChoice.check(R.id.chipUsd)
            }
            viewModel.refreshList(id)
        }
    }

    private fun observeViewModel() {
        viewModel.currencyList.observe(this) {
            adapter.submitList(it)
        }
        viewModel.successfulDownload.observe(this) {
            if (it) {
                binding.llError.visibility = GONE
                binding.rvCurrencyList.visibility = VISIBLE
            } else {
                binding.llError.visibility = VISIBLE
                binding.rvCurrencyList.visibility = GONE
            }
        }
        viewModel.loading.observe(this) {
            binding.pbLoading.visibility = if (it) VISIBLE else GONE
        }
        viewModel.refresh.observe(this) {
            binding.swipeRefresh.isRefreshing = false
        }
        viewModel.failRefresh.observe(this) {
            Toast(this).showCustomToast()
        }
    }

    private fun Toast.showCustomToast() {
        val layout = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.toastContainer))

        this.apply {
            setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 50)
            duration = Toast.LENGTH_LONG
            view = layout
            show()
        }
    }

    companion object {
        const val USD = "usd"
        private const val RUB = "rub"
    }
}