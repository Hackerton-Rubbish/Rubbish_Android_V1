package com.example.rubbiish_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.rubbiish_android.R
import com.example.rubbiish_android.util.DialogUtil
import com.example.rubbiish_android.util.SharedPreferenceHelper
import kotlinx.android.synthetic.main.fragment_login.*
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

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

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, VisualizeFragment()).commit()

        bnv_main.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.first -> replace(VisualizeFragment())
                R.id.third -> replace(MatchFragment())
                R.id.four -> replace(ProfileFragment())
                else -> false
            }
            true
        }
    }

    fun replace(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment).commit()
    }
}