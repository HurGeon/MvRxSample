package com.example.mvrxsample.domain

import io.reactivex.Single

interface NewsRepository {

    fun getNews(language: String) : Single<List<News>>
}
