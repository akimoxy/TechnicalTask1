package com.example.technicaltask1

import android.app.Application
import com.example.technicaltask1.di.presentationModule
import org.koin.core.context.GlobalContext.startKoin
import org.koin.android.ext.koin.androidContext

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(presentationModule)
        }

    }
}