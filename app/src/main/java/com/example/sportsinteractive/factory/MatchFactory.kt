package com.example.sportsinteractive.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sportsinteractive.repository.MatchRepository
import com.example.sportsinteractive.viewModel.MatchViewModel

class MatchFactory (val repo: MatchRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MatchViewModel(repo) as T
    }
}