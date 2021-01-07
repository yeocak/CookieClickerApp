package com.example.cookieclickerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.cookieclickerapp.MainActivity
import com.example.cookieclickerapp.R
import com.example.cookieclickerapp.datas.CookieData
import kotlinx.android.synthetic.main.fragment_clicker.*

class ClickerFragment : Fragment() {

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

        val animate = AnimationUtils.loadAnimation((activity as MainActivity), R.anim.cookie_zoom)

        btnClick.setOnClickListener {
            CookieData.cookie+=CookieData.clickAdd
            if(CookieData.animation){
                btnClick.startAnimation(animate)
            }
        }

        tvEverySecond.text = "Every second:\n${String.format("%.1f", CookieData.everyMiniSecond*10)}"

    }
}