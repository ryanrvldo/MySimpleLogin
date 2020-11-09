package com.ryanrvldo.mysimplelogin.core

class UserRepository(private val sessionManager: SessionManager) {

    companion object {
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(session: SessionManager): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(session)
            }
    }

    fun loginUser(username: String) {
        sessionManager.createLoginSession()
        sessionManager.saveToPreference(SessionManager.KEY_USERNAME, username)
    }

    fun getUser() = sessionManager.getFromPreference(SessionManager.KEY_USERNAME)

    fun isUserLogin() = sessionManager.isLogin

    fun logoutUser() = sessionManager.logout()
}
