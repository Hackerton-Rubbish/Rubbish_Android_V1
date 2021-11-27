package com.example.rubbiish_android.data.sign

data class LoginResponse(
    val status: Int,
    val detail: String,
    val data: Data
){
    data class Data(
        val token: String
    )
}
