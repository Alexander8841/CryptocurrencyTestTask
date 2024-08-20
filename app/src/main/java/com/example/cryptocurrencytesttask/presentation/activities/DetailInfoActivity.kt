package com.example.cryptocurrencytesttask.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptocurrencytesttask.databinding.ActivityDetailInfoBinding
import com.example.cryptocurrencytesttask.presentation.CurrencyApp
import com.example.cryptocurrencytesttask.presentation.viewModels.CurrencyViewModel
import com.squareup.picasso.Picasso
import javax.inject.Inject

class DetailInfoActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetailInfoBinding.inflate(layoutInflater)
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

        setToolBar()
        observeViewModel()

        val id = intent.getStringExtra(ID) ?: throw RuntimeException("Currency id is null")
        viewModel.getDetailInfo(id)

        binding.buttonTryAgain.setOnClickListener {
            viewModel.getDetailInfo(id)
            binding.llError.visibility = GONE
        }
    }

    private fun setToolBar() {
        setSupportActionBar(binding.toolBar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun observeViewModel() {
        viewModel.detailInfo.observe(this) {
            with(binding) {
                Picasso.get().load(it.imageUrl).into(ivLogo)
                tvDescription.text = it.description
                tvCategories.text = it.categories
                supportActionBar?.title = it.name
            }
        }
        viewModel.successfulDownload.observe(this) {
            if (it) {
                binding.llError.visibility = GONE
                binding.llDetailInfo.visibility = VISIBLE
            } else {
                binding.llError.visibility = VISIBLE
                binding.llDetailInfo.visibility = GONE
            }
        }
        viewModel.loading.observe(this) {
            binding.pbLoading.visibility = if (it) VISIBLE else GONE
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return true
    }

    companion object {
        private const val ID = "id"
        fun newIntent(context: Context, id: String) =
            Intent(context, DetailInfoActivity::class.java).apply { putExtra(ID, id) }
    }
}