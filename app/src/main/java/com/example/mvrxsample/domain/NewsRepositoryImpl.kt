package com.example.mvrxsample.domain

import io.reactivex.Single

class NewsRepositoryImpl(val service: NewsApiService): NewsRepository {

    override fun getNews(language: String): Single<List<News>> {
        return service.getNews(language)
    }
}
