package com.example.rubbiish_android.network

import com.example.rubbiish_android.data.sign.*
import retrofit2.Response
import retrofit2.http.*

interface SignApi {

    @Headers("Content-Type: application/json")
    @POST("/v1/user/signup/email-auth/")
    suspend fun sendEmail(
        @Body email: SendEmailRequest
    ) : Response<EmailResponse>

    @Headers("Content-Type: application/json")
    @PUT("/v1/user/signup/email-auth/")
    suspend fun emailCertify(
        @Query("email") email: String,
        @Body code: EmailCertifyRequest
    ) : Response<CertifyResponse>

    @Headers("Content-Type: application/json")
    @POST("v1/user/signup/")
    suspend fun register(
        @Body body: RegisterRequest
    ) : Response<RegisterResponse>

    @Headers("Content-Type: application/json")
    @POST("v1/user/signin/")
    suspend fun login(
        @Body body: LoginRequest
    ) : Response<LoginResponse>
}