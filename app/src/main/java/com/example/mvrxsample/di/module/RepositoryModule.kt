package com.example.mvrxsample.di.module

import com.example.mvrxsample.data.NewsRepositoryImpl
import com.example.mvrxsample.domain.NewsApiService
import com.example.mvrxsample.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    NetworkModule::class
])
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepositories(apiService: NewsApiService): NewsRepository =
        NewsRepositoryImpl(apiService)
}
