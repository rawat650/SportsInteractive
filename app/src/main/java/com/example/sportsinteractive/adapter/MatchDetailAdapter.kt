package com.example.sportsinteractive.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
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
            binding.playerName.text = playerData.NameFull
            binding.playerName.setOnClickListener {
//                Toast(this@MatchDetailAdapter,"the player name is + ${playerData.NameFull}",Toast.LENGTH_LONG).show()
            }


        }
    }

    override fun getItemCount() = playerDetailData.size
}