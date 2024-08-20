package com.example.cryptocurrencytesttask.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
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

        binding.llDetailInfo.visibility = VISIBLE
        val id = intent.getStringExtra(ID) ?: throw RuntimeException("Currency id is null")
        viewModel.getDetailInfo(id)
        viewModel.detailInfo.observe(this) {
            with(binding) {
                Picasso.get().load(it.imageUrl).into(ivLogo)
                tvDescription.text = it.description
                tvCategories.text = it.categories
            }
        }
    }

    companion object {
        private const val ID = "id"
        fun newIntent(context: Context, id: String) =
            Intent(context, DetailInfoActivity::class.java).apply { putExtra(ID, id) }
    }
}