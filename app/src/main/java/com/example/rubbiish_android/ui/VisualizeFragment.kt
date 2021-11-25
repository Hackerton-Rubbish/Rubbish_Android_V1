package com.example.rubbiish_android.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.example.rubbiish_android.R
import kotlinx.android.synthetic.main.fragment_visualize.*

class VisualizeFragment : Fragment() {

    private var result = 0
    private val literLiveData : MutableLiveData<Int> = MutableLiveData()
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

        literLiveData.postValue(0)
        visual_minus_fab.setOnClickListener{
            minus()
        }
        visual_plus_fab.setOnClickListener{
            plus()
        }
        literLiveData.observe(viewLifecycleOwner, {
            visual_liter_cnt_tv.text = literLiveData.value!!.toString()
        })
        visual_away_btn.setOnClickListener{
            if(result < literLiveData.value!! * -1)
                result = 0
            else
                result += literLiveData.value!!

            literLiveData.postValue(0)
            visual_liter_tv.text = "${result}L"
            if(result * 10 < 600)
                wave_lottie.scrollY = (result * 10)
            else
                wave_lottie.scrollY = 600
        }
        visual_one_liter.setOnClickListener{
            liter = 1
        }
        visual_five_liter.setOnClickListener{
            liter = 5
        }
        visual_ten_liter.setOnClickListener{
            liter = 10
        }
    }
    private fun minus() = literLiveData.postValue(literLiveData.value!! - liter)

    private fun plus() = literLiveData.postValue(literLiveData.value!! + liter)
}