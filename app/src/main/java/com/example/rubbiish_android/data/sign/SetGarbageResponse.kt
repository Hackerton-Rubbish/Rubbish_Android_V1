package com.example.rubbiish_android.data.sign

data class SetGarbageResponse(
    val status: String,
    val detail: String,
    val data: Data
){
    data class Data(
        val amount: Int
    )
}
