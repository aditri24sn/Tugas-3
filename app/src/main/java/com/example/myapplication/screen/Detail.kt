package com.example.myapplication.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*

@Composable
fun DetailScreen(
    onBackDaftar: () -> Unit,
    onBackLogin: () -> Unit
) {
    val nim = "235150701111033"
    val nama = "Aditri Surya Nugraha"
    val email = "aditri@email.com"
    val alamat = "Malang, Jawa Timur"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text("NIM: $nim", modifier = Modifier.padding(bottom = 8.dp))
        Text("Nama: $nama", modifier = Modifier.padding(bottom = 8.dp))
        Text("Email: $email", modifier = Modifier.padding(bottom = 8.dp))
        Text("Alamat: $alamat", modifier = Modifier.padding(bottom = 16.dp))

        Button(
            onClick = onBackDaftar,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        ) {
            Text("Kembali ke DAFTAR")
        }
        Button(
            onClick = onBackLogin,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kembali ke LOGIN")
        }
    }
}
