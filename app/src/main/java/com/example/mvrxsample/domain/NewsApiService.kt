package com.example.mvrxsample.domain

import com.example.mvrxsample.data.ArticleResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {


    @GET("rss?hl=ko&gl=KR&ceid=KR:ko")
    fun getNews(
//        @Query("hl") language: String= "ko",
//        @Query("gl") gl: String = "KR",
//        @Query("ceid") ceid: String = "KR:ko"
    ): Single<ArticleResponse>
}
