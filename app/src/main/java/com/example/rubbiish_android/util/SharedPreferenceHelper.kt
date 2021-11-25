package com.example.rubbiish_android.util

import android.content.Context

class SharedPreferenceHelper {
    private val prefs = RubbishApplication.context!!.getSharedPreferences(
        "Rubbish_Android_V1", Context.MODE_PRIVATE
    )

    var access_token: String?
        get() = prefs.getString("access_token", null)
        set(value){
            val editor = prefs.edit()
            editor.putString("access_token", value)
            editor.apply()
        }

    var email: String?
        get() = prefs.getString("email", null)
        set(value){
            val editor = prefs.edit()
            editor.putString("email", value)
            editor.apply()
        }

    companion object {
        private var sharedPreferencesHelper: SharedPreferenceHelper? = null

        fun getInstance(): SharedPreferenceHelper {
            if (sharedPreferencesHelper == null)
                sharedPreferencesHelper = SharedPreferenceHelper()
            return sharedPreferencesHelper!!
        }
    }
}