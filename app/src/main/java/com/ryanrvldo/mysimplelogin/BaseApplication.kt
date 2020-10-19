package com.ryanrvldo.mysimplelogin

import android.app.Application
import com.ryanrvldo.mysimplelogin.di.AppComponent
import com.ryanrvldo.mysimplelogin.di.DaggerAppComponent

open class BaseApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(
            applicationContext
        )
    }

}