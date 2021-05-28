package com.example.mvrxsample.domain.repository

import com.example.mvrxsample.data.dto.ArticleResponse
import io.reactivex.Single

interface NewsRepository {

    fun getNewsList(language: String): Single<ArticleResponse>
}
