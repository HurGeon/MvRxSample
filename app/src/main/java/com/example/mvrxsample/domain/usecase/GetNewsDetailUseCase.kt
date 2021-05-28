package com.example.mvrxsample.domain.usecase

import com.example.mvrxsample.domain.model.News
import io.reactivex.Single
import org.jsoup.Jsoup

class GetNewsDetailUseCase {

    fun convert(url: String?): Single<News> {
        return Single.just(Jsoup.connect(url).get())
            .map { document ->
                System.out.println("Response start")
                News(
                    document.selectFirst("meta[property=og:title]").attr("content"),
                    document.selectFirst("meta[property=og:image]").attr("content"),
                    document.selectFirst("meta[property=og:description]").attr("content"),
                )
            }
    }
}
