package com.example.sportsinteractive.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportsinteractive.Models.MatchDetailsData
import com.example.sportsinteractive.repository.MatchRepository
import kotlinx.coroutines.launch

class MatchViewModel(private val repository: MatchRepository) :ViewModel(){
    val matchData = MutableLiveData<MatchDetailsData>()
    val indVsNzDaa = MutableLiveData<MatchDetailsData>()
    val errorData = MutableLiveData<String>()
    fun getMatchData(){
        viewModelScope.launch{
            val response = repository.getMatchData()
            if(response.isSuccessful){
                matchData.postValue(response.body())
            }
            else{
                errorData.postValue(response.errorBody().toString())

            }
        }
    }
    fun getIndVNz(){
        viewModelScope.launch {
            val response = repository.getIndVsNz()
            if(response.isSuccessful){
                indVsNzDaa.postValue(response.body())

            }
            else{
                errorData.postValue(response.errorBody().toString())

            }
        }
    }

}