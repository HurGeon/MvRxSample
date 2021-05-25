package com.example.mvrxsample.module

import androidx.lifecycle.ViewModelProvider
import com.example.mvrxsample.di.base.ViewModelFactory
import com.example.mvrxsample.presenter.sample.NewsSampleViewModel_Factory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}