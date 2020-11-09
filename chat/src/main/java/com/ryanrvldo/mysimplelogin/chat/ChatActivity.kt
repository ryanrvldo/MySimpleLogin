package com.ryanrvldo.mysimplelogin.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ryanrvldo.mysimplelogin.core.SessionManager
import com.ryanrvldo.mysimplelogin.core.UserRepository
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val sessionManager = SessionManager(this)
        val userRepository = UserRepository.getInstance(sessionManager)
        tv_chat.text = "Hello ${userRepository.getUser()}! \n Welcome to Chat Feature"
    }
}
