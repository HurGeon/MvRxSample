package com.example.mvrxsample

import android.app.Application
import com.example.mvrxsample.di.components.AppComponent
import com.example.mvrxsample.di.components.DaggerAppComponent

class MyApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}
