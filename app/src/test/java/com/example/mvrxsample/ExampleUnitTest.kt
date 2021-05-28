package com.example.mvrxsample

import com.example.mvrxsample.domain.model.News
import com.example.mvrxsample.di.module.NetworkModule
import com.example.mvrxsample.di.module.RepositoryModule
import com.example.mvrxsample.domain.usecase.GetNewsDetailUseCase
import com.example.mvrxsample.domain.usecase.GetNewsUseCase
import junit.framework.Assert.assertEquals
import org.jsoup.Jsoup
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun getNewsWithJSoupTest() {
        val document = Jsoup.connect("https://news.sbs.co.kr/news/endPage.do?news_id=N1006330340").get()
        val metaTitle = document.select("meta[property=og:title]")
        val title = metaTitle.attr("content")
        // val elements = document.select("meta").find { element ->
        //     element.attr("property") == "og:title"
        // }?.attr("content")
        print(title)
    }

    @Test
    fun getNewsConvert() {
        val document = Jsoup.connect("https://news.sbs.co.kr/news/endPage.do?news_id=N1006330340").get()
        val metaTitle = document.selectFirst("meta[property=og:title]")
        val metaImage = document.selectFirst("meta[property=og:image]")
        val metaDescription = document.selectFirst("meta[property=og:description]")
        val title = metaTitle.attr("content")
        val description = metaDescription.attr("content")
        val imageUrl = metaImage.attr("content")

        print(News(title, description, imageUrl))
    }

    @Test
    fun getNewsListTest() {
        val startTime = System.currentTimeMillis()
        print("시작 : $startTime\n")

        val networkModule = NetworkModule()
        val repository =
            RepositoryModule().provideRepositories(networkModule.provideApiService(networkModule.provideRetrofit()))
        val text = repository.getNewsList("").blockingGet()
        val endTime = System.currentTimeMillis()
        print("끝 : $endTime\n")
        print(text)
    }

    @Test
    fun getDetailNewsTest() {
        val startTime = System.currentTimeMillis()
        print("시작 : $startTime\n")
        val networkModule = NetworkModule()
        val repository =
            RepositoryModule().provideRepositories(networkModule.provideApiService(networkModule.provideRetrofit()))
        val list = GetNewsUseCase(repository, GetNewsDetailUseCase()).invoke().subscribe({
            val endTime = System.currentTimeMillis()
            println("끝 : $endTime")
            println("처리시간  : ${endTime - startTime}")
            println(it)
        }, {
        }
        )
        Thread.sleep(50000)
    }
}
