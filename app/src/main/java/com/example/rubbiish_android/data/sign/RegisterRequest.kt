package com.example.rubbiish_android.data.sign

data class RegisterRequest(
    val email: String,
    val nickname: String,
    val passwd: String,
    val region: String,
    val role: String
)
