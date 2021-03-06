package com.example.listofflights

import android.app.Application
import com.example.listofflights.di.appModule
import com.example.listofflights.di.repoModule
import com.example.listofflights.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            androidLogger()
            modules(listOf(appModule, viewModelModule, repoModule))
        }
    }
}