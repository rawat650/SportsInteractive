package com.example.sportsinteractive.repository

import com.example.sportsinteractive.api.ApiService


class MatchRepository(private val apiService: ApiService) {
    suspend fun getMatchData() = apiService.getMatchData()
    suspend fun getIndVsNz() = apiService.getIndVsNz()

}