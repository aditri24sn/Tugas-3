package com.filkom.mycv2.view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserView : ViewModel() {
    var nim = mutableStateOf("")
    var nama = mutableStateOf("")
    var email = mutableStateOf("")
    var loginEmail = mutableStateOf("")

    fun simpanData(nimInput: String, namaInput: String, emailInput: String) {
        nim.value = nimInput
        nama.value = namaInput
        email.value = emailInput
    }

    fun login(emailInput: String) {
        loginEmail.value = emailInput
    }

    fun reset() {
        nim.value = ""
        nama.value = ""
        email.value = ""
        loginEmail.value = ""
    }
}