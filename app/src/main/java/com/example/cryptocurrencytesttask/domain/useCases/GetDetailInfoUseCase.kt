package com.example.cryptocurrencytesttask.domain.useCases

import com.example.cryptocurrencytesttask.domain.CoinRepository
import javax.inject.Inject

class GetDetailInfoUseCase @Inject constructor(
    private val repository: CoinRepository,
    private val id: String
) {
    operator fun invoke() = repository.getDetailInfo(id)
}