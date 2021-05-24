package com.example.mvrxsample

import android.app.Application

open class MyApplication : Application() {
    val appComponent : AppComponent by lazy {
        DaggerAppComponent.create()
    }
}
