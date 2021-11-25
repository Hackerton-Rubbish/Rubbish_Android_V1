package com.example.rubbiish_android.ui

import retrofit2.http.POST

data class Posts(
    val total_count:Int,
    val is_Next:Boolean,
    val posts:List<POST>
)
