package com.example.sportsinteractive.adapter

import android.app.AlertDialog
import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsinteractive.R
import com.example.sportsinteractive.databinding.MatchDetailItemListBinding

import com.example.sportsinteractive.pojo.PlayerDetail

class MatchDetailAdapter(val context: Context, val playerDetailData: MutableList<PlayerDetail>) :
    RecyclerView.Adapter<MatchDetailAdapter.MatchDetailHolder>() {


    class MatchDetailHolder(val binding: MatchDetailItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchDetailHolder {
        return MatchDetailHolder(
            MatchDetailItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MatchDetailHolder, position: Int) {
        val playerData = playerDetailData[position]
        holder.apply {
            if (playerData.isKeeper == true && playerData.isCaptain == true) {
                binding.playerName.text = playerData.NameFull + "(" + "C/WK" + ")"
            } else if (playerData.isCaptain == true) {
                binding.playerName.text = playerData.NameFull + "(" + "C" + ")"
            } else if (playerData.isKeeper == true) {
                binding.playerName.text = playerData.NameFull + "(" + "WK" + ")"
            } else {

                binding.playerName.text = playerData.NameFull

            }
            binding.playerName.setOnClickListener {

                val builder = AlertDialog.Builder(context, com.google.android.material.R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert).create()
                val view = LayoutInflater.from(context).inflate(R.layout.custom_alert_dialog, null)
                builder.setView(view)
                val tvStrikeRate = view.findViewById<TextView>(R.id.tvStrikeRate)
                val tvStyle = view.findViewById<TextView>(R.id.tvStyle)
                val tvRuns = view.findViewById<TextView>(R.id.tvRuns)
                val tvAverage = view.findViewById<TextView>(R.id.tvAverage)


                tvStrikeRate.text = ("Strike rate is : ")+ playerData.batting?.strikeRate
                tvStyle.text = "Batting Style is :"+playerData.batting?.style
                tvRuns.text = "Run :"+playerData.batting?.runs
                tvAverage.text = "The average is : " + playerData.batting?.average

                builder.setCanceledOnTouchOutside(true)
                builder.show()
            }



        }


    }

    override fun getItemCount() = playerDetailData.size
}
