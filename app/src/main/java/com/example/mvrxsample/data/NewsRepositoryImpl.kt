package com.example.mvrxsample.data

import com.example.mvrxsample.domain.NewsApiService
import com.example.mvrxsample.domain.repository.NewsRepository
import io.reactivex.Single

class NewsRepositoryImpl(val service: NewsApiService): NewsRepository {

    override fun getNews(language: String): Single<ArticleResponse> {
        return service.getNews(language)
    }
}
