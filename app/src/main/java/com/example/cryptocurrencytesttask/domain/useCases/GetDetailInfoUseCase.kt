package com.example.cryptocurrencytesttask.domain.useCases

import com.example.cryptocurrencytesttask.domain.repository.CoinRepository
import javax.inject.Inject

class GetDetailInfoUseCase @Inject constructor(private val repository: CoinRepository) {
    suspend operator fun invoke(id: String) = repository.getDetailInfo(id)
}