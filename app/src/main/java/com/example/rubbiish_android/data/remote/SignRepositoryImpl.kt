package com.example.rubbiish_android.data.remote

import com.example.rubbiish_android.data.sign.*
import com.example.rubbiish_android.network.ApiProvider
import com.example.rubbiish_android.network.SafeApiRequest
import retrofit2.Response

class SignRepositoryImpl : SignRepository, SafeApiRequest() {
    override suspend fun sendEmail(email: SendEmailRequest): Response<EmailResponse> {
        return safeApiCall { ApiProvider.getApi().sendEmail(email) }
    }

    override suspend fun emailCertify(
        email: String,
        code: EmailCertifyRequest
    ): Response<EmailResponse> {
        return safeApiCall { ApiProvider.getApi().emailCertify(email, code) }
    }

    override suspend fun register(body: RegisterRequest): Response<RegisterResponse> {
        return safeApiCall { ApiProvider.getApi().register(body) }
    }

    override suspend fun login(body: LoginRequest): Response<LoginResponse> {
        return safeApiCall { ApiProvider.getApi().login(body) }
    }
}