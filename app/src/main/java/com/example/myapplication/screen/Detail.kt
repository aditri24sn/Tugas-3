package com.example.myapplication.screen


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Detail(
    onDaftarClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "NIM: 235150701111033")
        Text(text = "Nama: Aditri Surya Nugraha")
        Text(text = "Email: aditrisurya@student.ub.ac.id")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onDaftarClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("DAFTAR")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Login")
        }
    }
}
