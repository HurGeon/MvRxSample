package com.example.mvrxsample.data

import com.example.mvrxsample.data.dto.ArticleResponse
import com.example.mvrxsample.domain.NewsApiService
import com.example.mvrxsample.domain.model.News
import com.example.mvrxsample.domain.repository.NewsRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.jsoup.Jsoup

class NewsRepositoryImpl(private val service: NewsApiService) : NewsRepository {

    override fun getNewsList(language: String): Single<ArticleResponse> {
        return service.getNewsList(language)
    }

    override fun getNewsDetail(url: String?): Single<News> {
        return Single.just(Jsoup.connect(url))
            .subscribeOn(Schedulers.io())
            .map { connection ->
                val document = connection.get()
                News(
                    document?.selectFirst("meta[property=og:title]")?.attr("content"),
                    document?.selectFirst("meta[property=og:description]")?.attr("content"),
                    document?.selectFirst("meta[property=og:image]")?.attr("content"),
                )
            }
    }
}
