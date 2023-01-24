package com.example.sportsinteractive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.sportsinteractive.adapter.Click
import com.example.sportsinteractive.adapter.MatchAdapter
import com.example.sportsinteractive.api.ApiService
import com.example.sportsinteractive.databinding.ActivityMainBinding
import com.example.sportsinteractive.factory.MatchFactory
import com.example.sportsinteractive.pojo.MatchDetailsData
import com.example.sportsinteractive.pojo.Teams
import com.example.sportsinteractive.repository.MatchRepository
import com.example.sportsinteractive.viewModel.MatchViewModel


class MainActivity : AppCompatActivity() , Click {
    lateinit var viewModel: MatchViewModel

    lateinit var binding: ActivityMainBinding

    private val apiService = ApiService.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,MatchFactory(MatchRepository(apiService))).get(MatchViewModel::class.java)

        viewModel.matchData.observe(this, Observer {
            setView(arrayListOf(it))


        }
        )
        viewModel.getMatchData()




    }

    private fun setView(data : List<MatchDetailsData>) {

        val adapter = MatchAdapter(this,data,this)
        binding.rvView.layoutManager = LinearLayoutManager(this)
        binding.rvView.adapter = adapter



    }

    override fun onclick(data: MatchDetailsData) {
        val intent = Intent(this,DetailActivity::class.java)
        val bundle =Bundle()
        bundle.putSerializable("playerName", data.Teams)
        intent.putExtras(bundle)
        startActivity(intent)
    }

}