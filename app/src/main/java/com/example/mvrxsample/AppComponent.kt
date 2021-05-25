package com.example.mvrxsample

import android.content.Context
import com.example.mvrxsample.module.NetworkModule
import com.example.mvrxsample.module.ViewModelFactoryModule
import com.example.mvrxsample.module.ViewModelModule
import com.example.mvrxsample.presenter.news.NewsFragment
import com.example.mvrxsample.presenter.sample.NewsSampleFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    ViewModelModule::class,
    ViewModelFactoryModule::class
])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
    fun inject(fragment: NewsSampleFragment)
    fun inject(fragment: NewsFragment)
}
