package com.example.rubbiish_android.ui

import retrofit2.Call
import retrofit2.http.*
import java.io.File

interface Network {
    //이미지 보내기
    @Multipart
    @POST("/v1/post/junk-art/")
    fun post_Request(
        @Path("title") title:String,
        @Path("content") content:String,
        @Part("image") image:File
    ):Call<Post>
}