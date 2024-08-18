package com.example.cryptocurrencytesttask.domain.useCases

import com.example.cryptocurrencytesttask.domain.repository.CoinRepository
import javax.inject.Inject

class GetCurrencyListUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke() = repository.getCurrencyList()
}