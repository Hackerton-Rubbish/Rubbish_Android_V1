package com.example.rubbiish_android.data.sign

data class EmailResponse(
    val status: String,
    val detail: String,
    val data: Data
){
    data class Data(
        val isEmailExist: Boolean,
        val emailSent: Boolean
    )
}
