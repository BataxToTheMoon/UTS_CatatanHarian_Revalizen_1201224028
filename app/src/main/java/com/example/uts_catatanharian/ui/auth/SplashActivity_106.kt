package com.example.uts_catatanharian.ui.auth

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_catatanharian.R
import com.example.uts_catatanharian.ui.dashboard.DashboardActivity_106
import com.example.uts_catatanharian.utils.SessionManager_106

@SuppressLint("CustomSplashScreen")
class SplashActivity_106 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sessionManager = SessionManager_106(this)

        Handler(Looper.getMainLooper()).postDelayed({
            if (sessionManager.isLoggedIn()) {
                val intent = Intent(this, DashboardActivity_106::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, LoginActivity_028::class.java)
                startActivity(intent)
                finish()
            }
        }, 1500)
    }
}
