package com.example.mvrxsample.domain.usecase

import com.example.mvrxsample.domain.model.News
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.jsoup.Jsoup

class GetNewsDetailUseCase {

    fun convert(url: String?): Single<News> {
        return Single.just(Jsoup.connect(url))
            .subscribeOn(Schedulers.io())
            .map { connection ->
                println("request Thread ${Thread.currentThread().name}")
                val document = connection.get()
                News(
                    document.selectFirst("meta[property=og:title]").attr("content"),
                    document.selectFirst("meta[property=og:description]").attr("content"),
                    document.selectFirst("meta[property=og:image]").attr("content"),
                )
            }.doOnError {
                println("error : $it")
            }
            .doAfterSuccess {
                println("response : ${it.title}")
            }
    }
}
