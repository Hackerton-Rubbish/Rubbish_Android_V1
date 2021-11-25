package com.example.rubbiish_android.util

import android.app.Application
import android.content.Context

class RubbishApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object{
        lateinit var context: Context
            private set
    }
}