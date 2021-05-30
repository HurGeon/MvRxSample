package com.example.mvrxsample.domain

import com.example.mvrxsample.data.dto.ArticleResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("rss")
    fun getNewsList(
        @Query("hl") language: String
    ): Single<ArticleResponse>
}
