package com.example.rubbiish_android.ui

import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.Multipart

interface Network {
    //이미지 보내기
    @Multipart
    @GET("/")
}