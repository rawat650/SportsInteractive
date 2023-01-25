package com.example.sportsinteractive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportsinteractive.adapter.MatchDetailAdapter
import com.example.sportsinteractive.databinding.ActivityDetailBinding
import com.example.sportsinteractive.pojo.PlayerDetail
import com.example.sportsinteractive.pojo.Teams
import com.example.sportsinteractive.utils.Utils
import com.google.gson.Gson

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    var pakPlayerDetailList : MutableList<PlayerDetail> = mutableListOf()
    var saPlayerDetailList : MutableList<PlayerDetail> = mutableListOf()

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val teamsData = intent.extras?.getSerializable("playerName") as Teams


        /*val playerData = intent.extras?.getSerializable("playerName") as PlayerDetail
        binding.dialogBox.name = playerData.NameFull
        */

        val pakPlayerData = teamsData.pak?.Players
        val saPlayerData = teamsData.south_africa?.Player
        pakPlayerDetailList.clear()
        saPlayerDetailList.clear()
        for (i in 0 until pakPlayerData?.keys?.size!!) {
            pakPlayerData.forEach {
                pakPlayerDetailList.add(it.value)
            }
        }

        for (i in 0 until saPlayerData?.keys?.size!!) {
            saPlayerData.forEach {
                saPlayerDetailList.add(it.value)
            }
        }
        binding.tvTeam1.text = teamsData.pak?.NameFull
        binding.tvTeam2.text = teamsData.south_africa?.NameFull
        binding.rcvtome.apply {
            this.layoutManager = LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
            this.adapter = MatchDetailAdapter(this@DetailActivity,  pakPlayerDetailList)
        }

        binding.rcvforothers.apply {
            this.layoutManager = LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
            this.adapter = MatchDetailAdapter(this@DetailActivity,  saPlayerDetailList)
        }
    }
}