package com.example.sportsinteractive.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsinteractive.DetailActivity
import com.example.sportsinteractive.R
import com.example.sportsinteractive.databinding.ActivityDetailBinding
import com.example.sportsinteractive.databinding.MatchDetailItemListBinding
import com.example.sportsinteractive.databinding.MatchItemViewBinding
import com.example.sportsinteractive.pojo.MatchDetailsData
import com.example.sportsinteractive.pojo.PlayerDetail
import com.example.sportsinteractive.utils.Utils

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
            if (playerData.isKeeper == true && playerData.isCaptain==true) {
                binding.playerName.text = playerData.NameFull + "(" + "C/WK" + ")"
            } else if (playerData.isCaptain == true) {
                binding.playerName.text = playerData.NameFull + "(" + "C" + ")"
            }
            else if (playerData.isKeeper == true) {
                binding.playerName.text = playerData.NameFull + "(" + "W" + ")"
            }

            else {

                binding.playerName.text = playerData.NameFull

            }
           /* binding.playerName.setOnClickListener {
                val alert = AlertDialog.Builder(context)
       alert.setView(R.layout.custom_alert_dialog)

       alert.show()
                *//*var intent = Intent(context, DetailActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("diaData", playerData)
                intent.putExtras(bundle)
                context.startActivity(intent)*//*
*/



}


    }

    override fun getItemCount() = playerDetailData.size
}