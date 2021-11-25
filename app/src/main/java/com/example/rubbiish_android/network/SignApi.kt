package com.example.rubbiish_android.network

import com.example.rubbiish_android.data.sign.*
import retrofit2.Response
import retrofit2.http.*

interface SignApi {

    @Headers("Content-Type: application/json")
    @POST("/v1/user/signup/email-auth/")
    fun sendEmail(
        @Body email: SendEmailRequest
    ) : Response<EmailResponse>

    @Headers("Content-Type: application/json")
    @PUT("/v1/user/signup/email-auth/")
    fun emailCertify(
        @Query("email") email: String,
        @Body code: EmailCertifyRequest
    ) : Response<EmailResponse>

    @Headers("Content-Type: application/json")
    @POST("v1/user/signup/")
    fun register(
        @Body body: RegisterRequest
    ) : Response<RegisterResponse>

    @Headers("Content-Type: application/json")
    @POST("v1/user/signin/")
    fun login(
        @Body body: LoginRequest
    ) : Response<LoginResponse>
}