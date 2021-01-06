package com.example.cookieclickerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.cookieclickerapp.datas.CookieData
import com.example.cookieclickerapp.fragments.ClickerFragment
import com.example.cookieclickerapp.fragments.UpgradeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuChange(ClickerFragment())

        /* TODO
        * Make animations
        * Make settings tab:(Change theme, hack mode, go github, back, help)
        * Upgrade images
        * Add README
        * */

        fixedRateTimer("timer",true,0,100){
            runOnUiThread {
                CookieData.apply {
                    cookie += everyMiniSecond
                }
                supportFragmentManager.findFragmentById(R.id.mainFragment)?.view?.findViewById<TextView>(R.id.tvCookieCount)?.apply {
                    text = String.format("%.1f", CookieData.cookie)
                }
            }
        }

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