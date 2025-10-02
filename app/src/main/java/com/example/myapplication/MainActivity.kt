package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.screen.Daftar
import com.example.myapplication.screen.Detail
import com.example.myapplication.screen.Login

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
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavDestination.Login
    ) {
        composable(NavDestination.Login) {
            Login(
                onLoginClick = { navController.navigate(NavDestination.Detail) },
                onDaftarClick = { navController.navigate(NavDestination.Daftar) }
            )
        }

        composable(NavDestination.Daftar) {
            Daftar(
                onSimpanClick = {
                    navController.navigate(NavDestination.Detail)
                }
            )
        }

        composable(NavDestination.Detail) {
            Detail(
                onDaftarClick = { navController.navigate(NavDestination.Daftar) },
                onLoginClick = {
                    navController.popBackStack(
                        NavDestination.Login,
                        inclusive = false
                    )
                }
            )
        }
    }
}
