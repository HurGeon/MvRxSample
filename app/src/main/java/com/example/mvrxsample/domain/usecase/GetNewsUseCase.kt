package com.example.mvrxsample.domain.usecase

import com.example.mvrxsample.domain.model.News
import com.example.mvrxsample.domain.repository.NewsRepository
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
    private val getNewsDetailUseCase: GetNewsDetailUseCase
) {
    fun invoke(): Single<List<News>> {
        return newsRepository.getNewsList("")
            .flatMap { article ->
                Flowable.fromIterable(article.channel?.list).flatMapSingle {
                    System.out.println("Request Started")
                    getNewsDetailUseCase.convert(it.link)
                }.toList()
            }
    }
}
