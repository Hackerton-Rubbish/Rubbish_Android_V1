package com.example.rubbiish_android.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rubbiish_android.data.remote.SignRepositoryImpl
import com.example.rubbiish_android.data.sign.*
import kotlinx.coroutines.launch

class SignViewModel : ViewModel() {
    private val signRepository = SignRepositoryImpl()
    private val _emailLiveData: MutableLiveData<EmailResponse> = MutableLiveData()
    private val _certifyLiveData: MutableLiveData<CertifyResponse> = MutableLiveData()
    private val _registerLiveData: MutableLiveData<RegisterResponse> = MutableLiveData()
    private val _loginLiveData: MutableLiveData<LoginResponse> = MutableLiveData()
    val emailLiveData = _emailLiveData
    val certifyLiveData = _certifyLiveData
    val registerLiveData = _registerLiveData
    val loginLiveData = _loginLiveData

    fun sendEmail(email: SendEmailRequest){
        viewModelScope.launch {
            val response = signRepository.sendEmail(email)
            if(response.isSuccessful){
                _emailLiveData.postValue(response.body())
            }
        }
    }

    fun emailCertify(email: String, code: EmailCertifyRequest){
        viewModelScope.launch {
            val response = signRepository.emailCertify(email, code)
            if(response.isSuccessful){
                _certifyLiveData.postValue(response.body())
            }
        }
    }

    fun register(body: RegisterRequest){
        viewModelScope.launch {
            val response = signRepository.register(body)
            if(response.isSuccessful){
                _registerLiveData.postValue(response.body())
            }
        }
    }

    fun login(body: LoginRequest){
        viewModelScope.launch {
            val response = signRepository.login(body)
            if(response.isSuccessful){
                _loginLiveData.postValue(response.body())
            }
        }
    }
}