package com.example.myapplication.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Detail Data", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))

        Text("NIM     : 235150701111033")
        Text("Nama    : Aditri Surya Nugraha")
        Text("Email   : aditri@example.com")
        Text("Alamat  : Malang, Indonesia")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { /* nanti kembali ke daftar */ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("DAFTAR")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen() {
    MaterialTheme {
        DetailScreen()
    }
}
