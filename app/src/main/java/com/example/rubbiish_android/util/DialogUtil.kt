package com.example.rubbiish_android.util

import android.app.Activity
import com.example.rubbiish_android.R
import org.aviran.cookiebar2.CookieBar

class DialogUtil(private val activity: Activity) {
    fun cookieBarBuilder(
        title: Int,
        message: String?,
        res_message: Int?,
        backgroundColor: Int,
    ) {
        if (message != null) {
            CookieBar.build(activity)
                .setTitle(title)
                .setMessage(message)
                .setTitleColor(R.color.white)
                .setBackgroundColor(backgroundColor)
                .show()
        } else {
            CookieBar.build(activity)
                .setTitle(title)
                .setMessage(res_message!!)
                .setTitleColor(R.color.white)
                .setBackgroundColor(backgroundColor)
                .show()
        }
    }
}