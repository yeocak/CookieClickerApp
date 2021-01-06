package com.example.cookieclickerapp.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.cookieclickerapp.R
import com.example.cookieclickerapp.datas.CookieData
import com.example.cookieclickerapp.datas.SingleUpgrade
import kotlinx.android.synthetic.main.single_upgrade.view.*

class UpgradeAdapter(
    private val upgradeList: MutableList<SingleUpgrade>
) : RecyclerView.Adapter<UpgradeAdapter.VHUpgrade>() {
    class VHUpgrade(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHUpgrade {
        return VHUpgrade(
            LayoutInflater.from(parent.context).inflate(
                R.layout.single_upgrade,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VHUpgrade, position: Int) {
        val curUp = upgradeList[position]
        holder.itemView.apply {
            tvUpgradeName.text = curUp.name
            tvUpgradeCost.text = "Cost: ${curUp.cost}"
            tvUpgradeCount.text = curUp.count.toString()

            if(!curUp.isOpen){
                btnBuy.text = "LOCKED"
                btnBuy.isEnabled = false
                ivLockBlock.isVisible = true
            }
            else if(CookieData.cookie < curUp.cost){
                btnBuy.text = "NOT ENOUGH COOKIE"
                btnBuy.isEnabled = false
                ivLockBlock.isVisible = true
                ivLockBlock.setBackgroundColor(ContextCompat.getColor(context.applicationContext,R.color.customHalfLittleBlack))
            }
            else{
                btnBuy.text = "BUY"
                btnBuy.isEnabled = true
                ivLockBlock.isVisible = false
            }

            btnBuy.setOnClickListener {
                CookieData.apply {
                    upgradeList[position].count += 1
                    cookie-=curUp.cost

                    everyMiniSecond += curUp.value
                }
                curUp.cost += ((0.2)*curUp.cost).toLong()

                if(position != upgradeList.size-1){
                    CookieData.upgradeList[position+1].isOpen = true
                }
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return upgradeList.size
    }
}