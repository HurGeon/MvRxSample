package com.example.mvrxsample

import com.example.mvrxsample.module.NetworkModule
import org.junit.Test

import org.junit.Assert.*

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
    fun getNewsTest() {
        val networkModule = NetworkModule()
        var repository = networkModule.provideRepositories(networkModule.provideApiService(networkModule.provideRetrofit()))
        var text = repository.getNews("https://news.sbs.co.kr/news/endPage.do?news_id=N1006330340").blockingGet()
        print(text)
    }

    @Test
    fun getNewsListTest() {
        val networkModule = NetworkModule()
        var repository = networkModule.provideRepositories(networkModule.provideApiService(networkModule.provideRetrofit()))
        var text = repository.getNewsList("").blockingGet()
        print(text)
    }
}
