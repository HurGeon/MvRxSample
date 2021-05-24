package com.example.mvrxsample

import com.example.mvrxsample.module.ApplicationModule
import com.example.mvrxsample.module.NetworkModule
import com.example.mvrxsample.module.ViewModelModule
import com.example.mvrxsample.presenter.sample.NewsSampleFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class,
    ViewModelModule::class
])
@Singleton
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: NewsSampleFragment)
}
