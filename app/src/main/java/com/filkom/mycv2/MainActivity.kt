package com.filkom.mycv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.filkom.mycv2.screen.Daftar
import com.filkom.mycv2.screen.Detail
import com.filkom.mycv2.screen.Login
import com.filkom.mycv2.ui.theme.MyCV2Theme
import com.filkom.mycv2.view.UserView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCV2Theme {
                Tugas6()
            }
        }
    }
}

@Composable
fun Tugas6() {
    val navController = rememberNavController()
    val userView: UserView = viewModel()

    NavHost(
        navController = navController,
        startDestination = NavDestination.Login
    ) {
        // Halaman Login
        composable(NavDestination.Login) {
            Login(
                onLoginClick = { email ->
                    userView.login(email)
                    navController.navigate(NavDestination.Detail)
                },
                onDaftarClick = { navController.navigate(NavDestination.Daftar) }
            )
        }

        // Halaman Daftar
        composable(NavDestination.Daftar) {
            Daftar(
                onSimpanClick = { nim, nama, email ->
                    userView.simpanData(nim, nama, email)
                    navController.navigate(NavDestination.Detail)
                }
            )
        }

        // Halaman Detail
        composable(NavDestination.Detail) {
            Detail(
                userView = userView, // ← perhatikan huruf kecil
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

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    MyCV2Theme {
        Tugas6()
    }
}
