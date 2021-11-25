package com.example.rubbiish_android.data.sign

data class RegisterResponse(
    val status: Int,
    val detail: String,
    val data: Data
){
    data class Data(
        val emailExists: Boolean,
        val validNickname: Boolean,
        val validPassword: Boolean
    )
}
