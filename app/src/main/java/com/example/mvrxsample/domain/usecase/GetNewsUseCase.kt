package com.example.mvrxsample.domain.usecase

import com.example.mvrxsample.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
) {

}
