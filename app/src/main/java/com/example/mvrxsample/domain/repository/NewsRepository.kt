package com.example.mvrxsample.domain.repository

import com.example.mvrxsample.data.ArticleResponse
import io.reactivex.Single

interface NewsRepository {

    fun getNews(language: String) : Single<ArticleResponse>
}
