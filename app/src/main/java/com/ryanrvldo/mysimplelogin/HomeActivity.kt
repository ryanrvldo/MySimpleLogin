package com.ryanrvldo.mysimplelogin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.ryanrvldo.mysimplelogin.core.SessionManager
import com.ryanrvldo.mysimplelogin.core.UserRepository
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sessionManager = SessionManager(this)
        userRepository = UserRepository.getInstance(sessionManager)

        tv_welcome.text = "Welcome ${userRepository.getUser()}"

        btn_logout.setOnClickListener {
            userRepository.logoutUser()
            moveToMainActivity()
        }

        fab.setOnClickListener {
            try {
                installChatModule()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Module not found.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun moveToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun installChatModule() {
        val splitInstallManager = SplitInstallManagerFactory.create(this)
        val moduleChat = "chat"
        if (splitInstallManager.installedModules.contains(moduleChat)) {
            moveToChatActivity()
            Toast.makeText(this, "Open module.", Toast.LENGTH_SHORT).show()
        } else {
            val request = SplitInstallRequest.newBuilder()
                .addModule(moduleChat)
                .build()

            splitInstallManager.startInstall(request)
                .addOnSuccessListener {
                    Toast.makeText(this, "Success installing chat module.", Toast.LENGTH_SHORT)
                        .show()
                    moveToChatActivity()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Error installing module.", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun moveToChatActivity() {
        startActivity(Intent(this, Class.forName("com.ryanrvldo.mysimplelogin.chat.ChatActivity")))
    }
}
