package com.example.rubbiish_android.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.example.rubbiish_android.R
import com.example.rubbiish_android.data.sign.SetGarbageRequest
import com.example.rubbiish_android.util.DialogUtil
import com.example.rubbiish_android.util.SharedPreferenceHelper
import com.example.rubbiish_android.viewmodel.VisualizeViewModel
import kotlinx.android.synthetic.main.fragment_visualize.*
import java.text.SimpleDateFormat
import java.util.*

class VisualizeFragment : Fragment() {

    private val prefs = SharedPreferenceHelper.getInstance()
    private val literLiveData: MutableLiveData<Int> = MutableLiveData()
    private val viewModel = VisualizeViewModel()
    private var liter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_visualize, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dialogUtil = DialogUtil(requireActivity())
        val currentTime = Calendar.getInstance().time
        val yearFormat = SimpleDateFormat("yy", Locale.getDefault())
        val monthFormat = SimpleDateFormat("MM", Locale.getDefault())
        val year = yearFormat.format(currentTime)
        val month = monthFormat.format(currentTime)

        literLiveData.postValue(0)
        viewModel.getGarbage(year, month)
        viewModel.setAmountLiveData.observe(viewLifecycleOwner, {
            when(it.status){
                200 -> {
//                    visual_liter_tv.text = "${it.data.amount}L"
//                    if (it.data.amount * 10 < 600)
//                        wave_lottie.scrollY = (it.data.amount * 10)
//                    else
//                        wave_lottie.scrollY = 600
                    prefs.liter = it.data.amount.toString()
                    setAmount(it.data.amount)
                }
                else -> {
                    dialogUtil.cookieBarBuilder(
                        R.string.setAmount_fail_title,
                        null,
                        R.string.setAmount_fail_content,
                        R.color.red
                    )
                }
            }
        })
        viewModel.getAmountLiveData.observe(viewLifecycleOwner, {
            when(it.status){
                200 ->{
                    prefs.liter = it.data.amount.toString()
                    setAmount(it.data.amount)
                }
                else -> {
                    dialogUtil.cookieBarBuilder(
                        R.string.getAmount_fail_title,
                        null,
                        R.string.getAmount_fail_content,
                        R.color.red
                    )
                }
            }
        })
        literLiveData.observe(viewLifecycleOwner, {
            visual_liter_cnt_tv.text = literLiveData.value!!.toString()
        })

        visual_minus_fab.setOnClickListener {
            minus()
        }
        visual_plus_fab.setOnClickListener {
            plus()
        }
        visual_away_btn.setOnClickListener {
            val body = SetGarbageRequest(year, month, literLiveData.value!!.toString())
            viewModel.setGarbage(body)
            literLiveData.postValue(0)
        }
        visual_one_liter.setOnClickListener {
            liter = 1
        }
        visual_five_liter.setOnClickListener {
            liter = 5
        }
        visual_ten_liter.setOnClickListener {
            liter = 10
        }
    }

    private fun plus() = literLiveData.postValue(literLiveData.value!! + liter)

    private fun minus() = literLiveData.postValue(literLiveData.value!! - liter)

    private fun setAmount(liter : Int){
        visual_liter_tv.text = "${liter}L"
        if (liter * 10 < 600)
            wave_lottie.scrollY = (liter * 10)
        else
            wave_lottie.scrollY = 600
    }

}