package com.example.mvrxsample.domain.repository

import com.example.mvrxsample.domain.News
import io.reactivex.Single

interface NewsRepository {

    fun getNews(language: String) : Single<List<News>>
}
