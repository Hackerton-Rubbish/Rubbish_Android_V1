package com.example.rubbiish_android.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rubbiish_android.R
import com.example.rubbiish_android.data.sign.LoginRequest
import com.example.rubbiish_android.util.DialogUtil
import com.example.rubbiish_android.util.SharedPreferenceHelper
import com.example.rubbiish_android.viewmodel.SignViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private val prefs = SharedPreferenceHelper.getInstance()
    private val viewModel = SignViewModel()
    private lateinit var dialogUtil: DialogUtil
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialogUtil = DialogUtil(requireActivity())

        viewModel.loginLiveData.observe(viewLifecycleOwner, {
            when(it.status){
                200 -> {
                    prefs.access_token = it.data.token
                    prefs.name = login_name_et.text.toString()
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    requireActivity().startActivity(intent)
                }
                202 -> {
                    dialogUtil.cookieBarBuilder(
                        R.string.login_fail_title,
                        null,
                        R.string.login_fail_content,
                        R.color.red
                    )
                }
            }
        })

        login_btn.setOnClickListener{
            if(login_name_et.text.toString() == "" || login_pass_et.text.toString() == ""){
                dialogUtil.cookieBarBuilder(
                    R.string.login_error_title,
                    null,
                    R.string.login_error_content,
                    R.color.red
                )
            } else {
                val body = LoginRequest(login_name_et.text.toString(), login_pass_et.text.toString())
                viewModel.login(body)
            }
        }
        login_to_register.setOnClickListener{
            (activity as SignActivity).replace(CertifyFragment())
        }
    }
}