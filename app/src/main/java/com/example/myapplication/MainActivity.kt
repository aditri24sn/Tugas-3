package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.example.myapplication.screen.DaftarScreen
import com.example.myapplication.screen.DetailScreen
import com.example.myapplication.screen.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var currentScreen by remember { mutableStateOf("login") }

    when (currentScreen) {
        "login" -> LoginScreen(
            onLogin = { currentScreen = "detail" },
            onDaftar = { currentScreen = "daftar" }
        )
        "daftar" -> DaftarScreen(
            onDaftar = { currentScreen = "detail" }
        )
        "detail" -> DetailScreen(
            onBackDaftar = { currentScreen = "daftar" },
            onBackLogin = { currentScreen = "login" }
        )
    }
}
