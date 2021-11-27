package com.example.rubbiish_android.data.sign

data class CertifyResponse(
    val status: Int,
    val detail: String,
    val data: Data
){
    data class Data(
        val isEmailExist: Boolean,
        val emailSent: Boolean
    )
}
