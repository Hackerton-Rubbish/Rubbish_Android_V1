package com.example.rubbiish_android.data.remote

import com.example.rubbiish_android.data.sign.*
import retrofit2.Response

interface SignRepository {
    suspend fun sendEmail(email: SendEmailRequest) : Response<EmailResponse>
    suspend fun emailCertify(email: String, code: EmailCertifyRequest) : Response<CertifyResponse>
    suspend fun register(body: RegisterRequest) : Response<RegisterResponse>
    suspend fun login(body: LoginRequest) : Response<LoginResponse>
}