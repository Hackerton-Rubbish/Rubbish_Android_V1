package com.example.rubbiish_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.rubbiish_android.R

class SignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.sign_container, LoginFragment()).commit()
    }

    fun replace(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(R.id.sign_container, fragment).commit()
    }

    fun popBackStack(fragment: Fragment){
        val fragmentManager = this.supportFragmentManager
        fragmentManager.beginTransaction().remove(fragment).commit()
        fragmentManager.popBackStack()
    }
}