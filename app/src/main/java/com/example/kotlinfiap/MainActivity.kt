package com.example.kotlinfiap


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.kotlinfiap.screens.InitialScreen
import com.example.kotlinfiap.ui.theme.KotlinfiapTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinfiapTheme {
                InitialScreen()
            }
        }
    }
}


