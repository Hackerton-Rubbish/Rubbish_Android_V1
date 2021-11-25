package com.example.rubbiish_android.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rubbiish_android.R
import com.example.rubbiish_android.util.DialogUtil
import com.example.rubbiish_android.util.SharedPreferenceHelper
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private val prefs = SharedPreferenceHelper.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cur_liter.text = prefs.liter

        leave.setOnClickListener{
            val intent = Intent(requireContext(), SignActivity::class.java)
            requireActivity().startActivity(intent)

            val dialogUtil = DialogUtil(requireActivity())
            dialogUtil.cookieBarBuilder(
                R.string.leave,
                null,
                R.string.leave2,
                R.color.primary
            )
        }
    }
}