package com.example.rubbiish_android.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rubbiish_android.R
import com.example.rubbiish_android.data.sign.RegisterRequest
import com.example.rubbiish_android.util.DialogUtil
import com.example.rubbiish_android.util.SharedPreferenceHelper
import com.example.rubbiish_android.viewmodel.SignViewModel
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    private val prefs = SharedPreferenceHelper.getInstance()
    private val viewModel = SignViewModel()
    private lateinit var dialogUtil: DialogUtil
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialogUtil = DialogUtil(requireActivity())
        viewModel.registerLiveData.observe(viewLifecycleOwner, {
            if(it.status == 200){
                if(it.data.emailExists && it.data.validNickname && it.data.validPassword){
                    dialogUtil.cookieBarBuilder(
                        R.string.register_success_title,
                        null,
                        R.string.register_success_content,
                        R.color.primary
                    )
                    (activity as SignActivity).replace(LoginFragment())
                }
                else {
                    dialogUtil.cookieBarBuilder(
                        R.string.register_empty_error_title,
                        null,
                        R.string.register_200_fail_content,
                        R.color.red
                    )
                }
            }
            else if(it.status == 403){
                dialogUtil.cookieBarBuilder(
                    R.string.register_not_exist_error_title,
                    null,
                    R.string.register_not_exist_error_content,
                    R.color.red
                )
            }
            else if(it.status == 406){
                dialogUtil.cookieBarBuilder(
                    R.string.register_406_error_title,
                    null,
                    R.string.register_406_error_content,
                    R.color.red
                )
            }
        })

        register_prev_ib.setOnClickListener{
            (activity as SignActivity).popBackStack(RegisterFragment())
        }

        register_btn.setOnClickListener{
            val name = register_name_et.text.toString().trim()
            val pass = register_pass_et.text.toString().trim()
            if(name != "" && pass != ""){
                var role = ""
                if(register_major_cb.isChecked)
                    role = "정크 아티스트"
                else
                    role = "일반 유저"
                val body = RegisterRequest(prefs.email!!, name, pass, register_region_et.text.toString().trim(), role)
                viewModel.register(body)
            } else{
                dialogUtil.cookieBarBuilder(
                    R.string.register_empty_error_title,
                    null,
                    R.string.register_empty_error_content,
                    R.color.red
                )
            }
        }
    }
}