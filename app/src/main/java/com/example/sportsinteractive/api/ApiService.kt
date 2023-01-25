package com.example.sportsinteractive.api

import com.example.sportsinteractive.constants.Constants
import com.example.sportsinteractive.pojo.MatchDetailsData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {


    @GET("sapk01222019186652.json")
    suspend fun getMatchData():Response<MatchDetailsData>
    @GET("nzin01312019187360.json")
    suspend fun getIndVsNz() : Response<MatchDetailsData>


    companion object {

        var retrofitService: ApiService? = null

        fun getInstance(): ApiService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitService = retrofit.create(ApiService::class.java)
            }
            return retrofitService!!
        }
    }

}