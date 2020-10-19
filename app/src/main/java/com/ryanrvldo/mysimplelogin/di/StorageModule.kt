package com.ryanrvldo.mysimplelogin.di

import android.content.Context
import com.ryanrvldo.mysimplelogin.SessionManager
import dagger.Module
import dagger.Provides

@Module
class StorageModule {

    @Provides
    fun provideSessionManager(context: Context) = SessionManager(context)

}