package com.example.mvrxsample.domain.repository

import com.example.mvrxsample.data.dto.ArticleResponse
import com.example.mvrxsample.domain.model.News
import io.reactivex.Single

interface NewsRepository {

    fun getNewsList(language: String): Single<ArticleResponse>

    fun getNewsDetail(url: String?): Single<News>
}
