package com.example.rubbiish_android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rubbiish_android.data.remote.VisualizeRepositoryImpl
import com.example.rubbiish_android.data.sign.SetGarbageRequest
import com.example.rubbiish_android.util.SharedPreferenceHelper
import kotlinx.coroutines.launch

class VisualizeViewModel : ViewModel() {

    private val visualizeRepository = VisualizeRepositoryImpl()
    private val prefs = SharedPreferenceHelper()

    fun setGarbage(body: SetGarbageRequest){
        viewModelScope.launch {
            val response = visualizeRepository.setGarbage()
        }
    }
}