package com.example.sportsinteractive.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsinteractive.databinding.MatchItemViewBinding
import com.example.sportsinteractive.Models.MatchDetailsData

class MatchAdapter(context: Context, val list: List<MatchDetailsData>, val click: Click) :
    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {
    class MatchViewHolder(val binding: MatchItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(
            MatchItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val matchData = list[position]
        holder.apply {
            binding.tvSeries.text = matchData.Matchdetail?.Series?.Name
            binding.tvVenue.text = matchData.Matchdetail?.Venue?.Name
            binding.tvDate.text = matchData.Matchdetail?.Match?.Date
            binding.tvTime.text = matchData.Matchdetail?.Match?.Time.toString()
            binding.tvMatch.text = matchData.Teams?.pak?.NameFull
            binding.tvTeam.text = matchData.Teams?.south_africa?.NameFull

            if (matchData.Teams?.nz != null &&
                matchData.Teams?.nz?.NameFull.toString().isNotEmpty()
            ) {
                binding.tvMatch.text = matchData.Teams?.nz?.NameFull

                binding.tvTeam.text = matchData.Teams?.ind?.NameFull
            } else {
                binding.tvMatch.text = matchData.Teams?.pak?.NameFull
                binding.tvTeam.text = matchData.Teams?.south_africa?.NameFull
            }
            binding.tvTeamOneScore.text =
                matchData.Innings.get(1).Total + "/" + matchData.Innings.get(1).Wickets + " ( " + matchData.Innings.get(
                    0
                ).Overs + " ) "
            binding.tvTeamTwoScore.text =
                matchData.Innings.get(0).Total + "/" + matchData.Innings.get(0).Wickets + " ( " + matchData.Innings.get(
                    1
                ).Overs + " ) "

            binding.tvResult.text = matchData.Matchdetail?.Result
            binding.tvPlayerOfTheMatch.text = matchData.Matchdetail?.PlayerMatch
            binding.tvStatus.text = matchData.Matchdetail?.Status


            binding.detailsScreen.setOnClickListener {
                click.onclick(matchData)
            }
        }

    }

    override fun getItemCount() = list.size


}

interface Click {
    fun onclick(data: MatchDetailsData)
}