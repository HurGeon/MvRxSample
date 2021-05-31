package com.example.mvrxsample.domain.usecase

import com.example.mvrxsample.domain.model.News
import com.example.mvrxsample.domain.repository.NewsRepository
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.Locale
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    fun invoke(): Single<List<News>> {
        return newsRepository.getNewsList(Locale.getDefault().language)
            .subscribeOn(Schedulers.io())
            .flatMap { article ->
                Flowable.fromIterable(article.channel?.list).flatMapSingle {
                    newsRepository.getNewsDetail(it.link)
                }.toList()
            }
    }
}
