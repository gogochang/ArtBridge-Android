package com.gogochang.artbridge.presentation.main

import com.gogochang.artbridge.ui.theme.ArtBridgeTheme
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.gogochang.artbridge.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setContent {
            ArtBridgeTheme {
                mainScreen()
            }
        }
    }
}