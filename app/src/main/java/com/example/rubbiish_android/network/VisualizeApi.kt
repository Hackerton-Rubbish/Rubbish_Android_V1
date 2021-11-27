package com.example.rubbiish_android.network

import com.example.rubbiish_android.data.sign.GetGarbageResponse
import com.example.rubbiish_android.data.sign.SetGarbageRequest
import com.example.rubbiish_android.data.sign.SetGarbageResponse
import retrofit2.Response
import retrofit2.http.*

interface VisualizeApi {
    @Headers("Content-Type: application/json")
    @POST("/v1/user/data/garbage-output/")
    suspend fun setGarbage(
        @Header("Authorization") header: String,
        @Body body: SetGarbageRequest
    ) : Response<SetGarbageResponse>

    @GET("/v1/user/data/garbage-output/")
    suspend fun getGarbage(
        @Header("Authorization") header: String,
        @Query("year") year: String,
        @Query("month") month: String
    ) : Response<GetGarbageResponse>
}