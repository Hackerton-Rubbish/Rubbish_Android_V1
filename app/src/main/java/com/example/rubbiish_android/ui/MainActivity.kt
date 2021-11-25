package com.example.rubbiish_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rubbiish_android.R
import com.example.rubbiish_android.util.DialogUtil
import com.example.rubbiish_android.util.SharedPreferenceHelper
import kotlinx.android.synthetic.main.fragment_login.*

class MainActivity : AppCompatActivity() {

    private val prefs = SharedPreferenceHelper.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialogUtil = DialogUtil(this)
        dialogUtil.cookieBarBuilder(
            R.string.login_success_title,
            "${prefs.name}님, 환영합니다!",
            R.string.login_success_content,
            R.color.primary
        )
    }
}