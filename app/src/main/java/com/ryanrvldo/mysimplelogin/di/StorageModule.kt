package com.ryanrvldo.mysimplelogin.di

import com.ryanrvldo.mysimplelogin.SessionManager
import com.ryanrvldo.mysimplelogin.UserRepository
import org.koin.dsl.module

val storageModule = module {
    factory {
        SessionManager(get())
    }

    single {
        UserRepository(get())
    }
}