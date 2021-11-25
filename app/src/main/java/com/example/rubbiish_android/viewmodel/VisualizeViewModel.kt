package com.example.rubbiish_android.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rubbiish_android.data.remote.VisualizeRepositoryImpl
import com.example.rubbiish_android.data.sign.GetGarbageResponse
import com.example.rubbiish_android.data.sign.SetGarbageRequest
import com.example.rubbiish_android.data.sign.SetGarbageResponse
import com.example.rubbiish_android.util.SharedPreferenceHelper
import kotlinx.coroutines.launch

class VisualizeViewModel : ViewModel() {

    private val visualizeRepository = VisualizeRepositoryImpl()
    private val prefs = SharedPreferenceHelper.getInstance()
    private val _setAmountLiveData: MutableLiveData<SetGarbageResponse> = MutableLiveData()
    private val _getAmountLiveData: MutableLiveData<GetGarbageResponse> = MutableLiveData()
    val setAmountLiveData = _setAmountLiveData
    val getAmountLiveData = _getAmountLiveData

    fun setGarbage(body: SetGarbageRequest) {
        viewModelScope.launch {
            val response = visualizeRepository.setGarbage(prefs.access_token!!, body)
            if (response.isSuccessful) {
                _setAmountLiveData.postValue(response.body())
            }
        }
    }

    fun getGarbage(year: String, month: String) {
        viewModelScope.launch {
            val response = visualizeRepository.getGarbage(prefs.access_token!!, year, month)
            if (response.isSuccessful) {
                _getAmountLiveData.postValue(response.body())
            }
        }
    }
}