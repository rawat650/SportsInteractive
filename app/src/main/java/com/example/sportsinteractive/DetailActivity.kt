package com.example.sportsinteractive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportsinteractive.adapter.MatchDetailAdapter
import com.example.sportsinteractive.databinding.ActivityDetailBinding
import com.example.sportsinteractive.Models.PlayerDetail
//import com.example.sportsinteractive.pojo.Players
import com.example.sportsinteractive.Models.Teams

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    var pakPlayerDetailList: MutableList<PlayerDetail> = mutableListOf()
    var saPlayerDetailList: MutableList<PlayerDetail> = mutableListOf()
    var indPlayerDetailList: MutableList<PlayerDetail> = mutableListOf()
    var nzPlayerDetailList: MutableList<PlayerDetail> = mutableListOf()

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val teamsData = intent.extras?.getSerializable("name") as Teams



        var pakPlayerData: Map<String, PlayerDetail>? = null
        var saPlayerData: Map<String, PlayerDetail>? = null
        var indPlayerData: Map<String, PlayerDetail>? = null
        var nzPlayerData: Map<String, PlayerDetail>? = null

        pakPlayerDetailList.clear()
        saPlayerDetailList.clear()
        indPlayerDetailList.clear()
        nzPlayerDetailList.clear()

        if (intent.getStringExtra("match1").equals("savspak")) {
            pakPlayerData = teamsData.pak?.Players
            saPlayerData = teamsData.south_africa?.Player
            pakPlayerData?.forEach {
                pakPlayerDetailList.add(it.value)
            }
            saPlayerData?.forEach {
                saPlayerDetailList.add(it.value)
            }
            binding.tvTeam1.text = teamsData.pak?.NameFull
            binding.tvTeam2.text = teamsData.south_africa?.NameFull
            binding.rcvTeamOne.apply {
                this.layoutManager =
                    LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
                this.adapter = MatchDetailAdapter(this@DetailActivity, pakPlayerDetailList)
            }

            binding.rcvTeamTwo.apply {
                this.layoutManager =
                    LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
                this.adapter = MatchDetailAdapter(this@DetailActivity, saPlayerDetailList)
            }
        } else if (intent.getStringExtra("match2").equals("indvsnz")) {
            indPlayerData = teamsData.ind?.Players
            nzPlayerData = teamsData.nz?.Players
            indPlayerData?.forEach {
                indPlayerDetailList.add(it.value)
            }
            nzPlayerData?.forEach {
                nzPlayerDetailList.add(it.value)
            }
            binding.tvTeam1.text = teamsData.ind?.NameFull
            binding.tvTeam2.text = teamsData.nz?.NameFull
            binding.rcvTeamOne.apply {
                this.layoutManager =
                    LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
                this.adapter = MatchDetailAdapter(this@DetailActivity, indPlayerDetailList)
            }

            binding.rcvTeamTwo.apply {
                this.layoutManager =
                    LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
                this.adapter = MatchDetailAdapter(this@DetailActivity, nzPlayerDetailList)
            }
        }

    }
}
