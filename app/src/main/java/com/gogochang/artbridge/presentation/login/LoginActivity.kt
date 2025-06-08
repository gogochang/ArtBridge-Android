package com.gogochang.artbridge.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import com.gogochang.artbridge.presentation.main.MainActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(onClick = {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            })
        }
    }
}