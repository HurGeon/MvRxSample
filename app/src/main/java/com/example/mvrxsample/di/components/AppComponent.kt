package com.example.mvrxsample.di.components

import android.content.Context
import com.example.mvrxsample.di.module.NetworkModule
import com.example.mvrxsample.di.module.RepositoryModule
import com.example.mvrxsample.di.module.UseCaseModule
import com.example.mvrxsample.presenter.news.NewsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    // fun inject(fragment: NewsSampleFragment)
    fun inject(fragment: NewsFragment)
}
