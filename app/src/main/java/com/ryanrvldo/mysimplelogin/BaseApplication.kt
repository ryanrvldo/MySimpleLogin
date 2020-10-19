package com.ryanrvldo.mysimplelogin

import android.app.Application
import com.ryanrvldo.mysimplelogin.di.storageModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(storageModule)
        }
    }

}