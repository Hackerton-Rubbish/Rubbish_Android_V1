package com.example.rubbiish_android.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rubbiish_android.R
import com.example.rubbiish_android.data.sign.EmailCertifyRequest
import com.example.rubbiish_android.data.sign.SendEmailRequest
import com.example.rubbiish_android.util.DialogUtil
import com.example.rubbiish_android.util.SharedPreferenceHelper
import com.example.rubbiish_android.viewmodel.SignViewModel
import kotlinx.android.synthetic.main.fragment_certify.*

class CertifyFragment : Fragment() {

    private val viewModel = SignViewModel()
    private val prefs = SharedPreferenceHelper.getInstance()
    private lateinit var dialogUtil: DialogUtil

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_certify, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialogUtil = DialogUtil(requireActivity())

        viewModel.emailLiveData.observe(viewLifecycleOwner, {
            if (!it.data.isEmailExist && it.data.emailSent) {
                dialogUtil.cookieBarBuilder(
                    R.string.send_email_success_title,
                    null,
                    R.string.send_email_success_content,
                    R.color.primary
                )
            } else if (it.data.isEmailExist) {
                dialogUtil.cookieBarBuilder(
                    R.string.send_email_error_title,
                    null,
                    R.string.send_email_fail_content,
                    R.color.red
                )
            }
        })
        viewModel.certifyLiveData.observe(viewLifecycleOwner, {
            if(it.status == 200){
                dialogUtil.cookieBarBuilder(
                    R.string.certify_success_title,
                    null,
                    R.string.certify_success_content,
                    R.color.primary
                )
                (activity as SignActivity).replace(RegisterFragment())
            }
            else if(it.status == 400){
                dialogUtil.cookieBarBuilder(
                    R.string.certify_fail_title,
                    null,
                    R.string.certify_fail_content,
                    R.color.red
                )
            }
            else if(it.status == 401){
                dialogUtil.cookieBarBuilder(
                    R.string.certify_code_wrong_title,
                    null,
                    R.string.certify_code_wrong_content,
                    R.color.red
                )
            }
        })

        certify_prev_ib.setOnClickListener {
            (activity as SignActivity).popBackStack(CertifyFragment())
        }
        certify_send_tv.setOnClickListener {
            if (certify_email_et.text.toString() != "") {
                prefs.email = certify_email_et.text.toString()
                viewModel.sendEmail(SendEmailRequest(certify_email_et.text.toString()))
            } else {
                dialogUtil.cookieBarBuilder(
                    R.string.send_email_error_title,
                    null,
                    R.string.send_email_error_content,
                    R.color.red
                )
            }
        }
        certify_btn.setOnClickListener {
            val code1 = certify_code_et1.text.toString()
            val code2 = certify_code_et2.text.toString()
            val code3 = certify_code_et3.text.toString()
            val code4 = certify_code_et4.text.toString()
            val code5 = certify_code_et5.text.toString()
            val code6 = certify_code_et6.text.toString()
            if (
                code1 != "" && code2 != "" && code3 != "" && code4 != "" && code5 != "" && code6 != ""
            ) {
                val code = EmailCertifyRequest(code1+code2+code3+code4+code5+code6)
                viewModel.emailCertify(prefs.email!!, code)
            }
        }
    }
}