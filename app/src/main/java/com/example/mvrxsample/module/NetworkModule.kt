package com.example.mvrxsample.module

import com.example.mvrxsample.domain.NewsApiService
import com.example.mvrxsample.domain.NewsRepository
import com.example.mvrxsample.domain.NewsRepositoryImpl
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://news.google.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    fun provideApiService(retrofit: Retrofit): NewsApiService = retrofit.create(NewsApiService::class.java)

    fun provideRepositories(apiService: NewsApiService): NewsRepository = NewsRepositoryImpl(apiService)

}
