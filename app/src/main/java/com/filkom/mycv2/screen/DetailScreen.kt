package com.filkom.mycv2.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.filkom.mycv2.view.UserView

@Composable
fun Detail(
    userView: UserView,
    onDaftarClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    val nim = userView.nim.value
    val nama = userView.nama.value
    val email = userView.email.value
    val emailLogin = userView.loginEmail.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        if (nim.isNotEmpty() && nama.isNotEmpty()) {
            Text("NIM: $nim")
            Text("Nama: $nama")
            Text("Email: $email")
        } else if (emailLogin.isNotEmpty()) {
            Text("Login Berhasil!")
            Text("Email: $emailLogin")
        } else {
            Text("Tidak ada data.")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onDaftarClick, modifier = Modifier.fillMaxWidth()) {
            Text("DAFTAR")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = onLoginClick, modifier = Modifier.fillMaxWidth()) {
            Text("Back to Login")
        }
    }
}

