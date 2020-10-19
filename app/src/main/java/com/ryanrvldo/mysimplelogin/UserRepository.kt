package com.ryanrvldo.mysimplelogin

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val sessionManager: SessionManager) {

    fun loginUser(username: String) {
        sessionManager.createLoginSession()
        sessionManager.saveToPreference(SessionManager.KEY_USERNAME, username)
    }

    fun getUser() = sessionManager.getFromPreference(SessionManager.KEY_USERNAME)

    fun isUserLogin() = sessionManager.isLogin

    fun logoutUser() = sessionManager.logout()
}