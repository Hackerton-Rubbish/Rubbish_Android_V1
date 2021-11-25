package com.example.rubbiish_android.data.remote

import com.example.rubbiish_android.data.sign.GetGarbageResponse
import com.example.rubbiish_android.data.sign.SetGarbageRequest
import com.example.rubbiish_android.data.sign.SetGarbageResponse
import com.example.rubbiish_android.network.ApiProvider
import com.example.rubbiish_android.network.SafeApiRequest
import retrofit2.Response

class VisualizeRepositoryImpl : ViusalizeRepository, SafeApiRequest(){
    override suspend fun setGarbage(
        header: String,
        body: SetGarbageRequest
    ): Response<SetGarbageResponse> {
        return safeApiCall { ApiProvider.getVisualApi().setGarbage(header, body) }
    }

    override suspend fun getGarbage(
        header: String,
        year: String,
        month: String
    ): Response<GetGarbageResponse> {
        return safeApiCall { ApiProvider.getVisualApi().getGarbage(header, year, month) }
    }
}