package com.example.cookieclickerapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.CalendarContract
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.cookieclickerapp.datas.CookieData
import com.example.cookieclickerapp.fragments.ClickerFragment
import com.example.cookieclickerapp.fragments.UpgradeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_clicker.*
import java.util.*
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuChange(ClickerFragment())

        /* TODO
        *  Make animations
        * Second counter
        * Upgrade images
        * Crash bug fixes
        * Add README
        * */

    }

    fun menuButton(v: View){
        when (v) {
            btnClicker -> menuChange(ClickerFragment())
            btnSettings -> TODO("Make settings tab")
            btnUpgrades -> menuChange(UpgradeFragment())
        }

    }

    private fun menuChange(frag: Fragment){
        val transaction = supportFragmentManager.beginTransaction()

        btnClicker.setTextColor(ContextCompat.getColor(applicationContext,R.color.customBlack))
        btnSettings.setTextColor(ContextCompat.getColor(applicationContext,R.color.customBlack))
        btnUpgrades.setTextColor(ContextCompat.getColor(applicationContext,R.color.customBlack))

        if(frag is ClickerFragment){
            btnClicker.setTextColor(ContextCompat.getColor(applicationContext,R.color.customBlue))
        }
        else if(frag is UpgradeFragment){
            btnUpgrades.setTextColor(ContextCompat.getColor(applicationContext,R.color.customBlue))
        }

        transaction.replace(R.id.mainFragment, frag).commit()
    }


}