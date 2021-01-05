package com.example.cookieclickerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cookieclickerapp.MainActivity
import com.example.cookieclickerapp.R
import com.example.cookieclickerapp.datas.CookieData
import kotlinx.android.synthetic.main.fragment_upgrade.*

class UpgradeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_upgrade, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapting = UpgradeAdapter(CookieData.upgradeList)

        rvUpgrades.adapter = adapting
        rvUpgrades.layoutManager = LinearLayoutManager(MainActivity())
    }
}