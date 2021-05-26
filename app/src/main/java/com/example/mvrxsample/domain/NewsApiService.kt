package com.example.mvrxsample.domain

import com.example.mvrxsample.data.dto.ArticleResponse
import com.example.mvrxsample.data.dto.NewsResponse
import com.example.mvrxsample.util.XmlAndHtmlConverters
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsApiService {


    @GET("rss?hl=ko&gl=KR&ceid=KR:ko")
    @XmlAndHtmlConverters.XML
    fun getNewsList(
//        @Query("hl") language: String= "ko",
//        @Query("gl") gl: String = "KR",
//        @Query("ceid") ceid: String = "KR:ko"
    ): Single<ArticleResponse>

    @GET
    @XmlAndHtmlConverters.HTML
//    @XmlAndHtmlConverters.Scalars
    fun getNews(@Url url:String): Single<NewsResponse>
}
