package com.example.myapplication.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DaftarScreen(
    onDaftar: () -> Unit
) {
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(value = nim, onValueChange = { nim = it }, label = { Text("NIM") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp))
        OutlinedTextField(value = nama, onValueChange = { nama = it }, label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp))
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp))
        OutlinedTextField(value = alamat, onValueChange = { alamat = it }, label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp))

        Button(
            onClick = onDaftar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("DAFTAR")
        }
    }
}
