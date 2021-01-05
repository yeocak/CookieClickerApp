package com.example.cookieclickerapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cookieclickerapp.MainActivity
import com.example.cookieclickerapp.R
import com.example.cookieclickerapp.datas.CookieData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_clicker.*
import java.util.*
import kotlin.concurrent.fixedRateTimer
import kotlin.math.round
import kotlin.math.roundToLong

class ClickerFragment : Fragment() {

    lateinit var hey: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_clicker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnClick.setOnClickListener {
            CookieData.cookie+=CookieData.clickAdd
        }
        hey()
    }

    override fun onStop() {
        super.onStop()
        hey.cancel()
    }



    fun hey(){
        hey = fixedRateTimer("timer",false,0,100){
            (activity as MainActivity).runOnUiThread {
                CookieData.click()
                tvCookieCount.text = String.format("%.1f", CookieData.cookie)
            }
        }
    }


}