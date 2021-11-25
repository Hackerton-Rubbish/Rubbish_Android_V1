package com.example.rubbiish_android.data.remote

import com.example.rubbiish_android.data.sign.GetGarbageResponse
import com.example.rubbiish_android.data.sign.SetGarbageRequest
import com.example.rubbiish_android.data.sign.SetGarbageResponse
import retrofit2.Response

interface GarbageRepository {
    suspend fun setGarbage(header: String, body: SetGarbageRequest) : Response<SetGarbageResponse>
    suspend fun getGarbage(header: String, year: String, month: String) : Response<GetGarbageResponse>
}