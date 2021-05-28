package com.example.mvrxsample.di.module

import com.example.mvrxsample.domain.repository.NewsRepository
import com.example.mvrxsample.domain.usecase.GetNewsDetailUseCase
import com.example.mvrxsample.domain.usecase.GetNewsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        RepositoryModule::class
    ]
)
class UseCaseModule {

    @Provides
    @Singleton
    fun providesUseCase(repository: NewsRepository, newsDetailUseCase: GetNewsDetailUseCase): GetNewsUseCase {
        return GetNewsUseCase(repository, newsDetailUseCase)
    }

    @Provides
    @Singleton
    fun providesDetailUseCase() = GetNewsDetailUseCase()
}
