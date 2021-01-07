package com.example.cookieclickerapp.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.cookieclickerapp.MainActivity
import com.example.cookieclickerapp.R
import com.example.cookieclickerapp.datas.CookieData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            swAnimation.isChecked = CookieData.animation
            etClick.setText(CookieData.clickAdd.toString())

        btnGithub.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://github.com/yeocak/CookieClickerApp")
            startActivity(intent)
        }

        swAnimation.setOnCheckedChangeListener { buttonView, isChecked ->
                CookieData.animation = swAnimation.isChecked
        }
    }

    override fun onStop() {
        super.onStop()
        etClick.text?.let {
            CookieData.clickAdd = etClick.text.toString().toInt()
        }
    }
}