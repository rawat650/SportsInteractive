package com.example.sportsinteractive.pojo

import com.google.gson.annotations.SerializedName

data class MatchDetailsData(@SerializedName("Matchdetail" ) var Matchdetail : MatchDetail? = MatchDetail(),
                            @SerializedName("Nuggets"     ) var Nuggets     : ArrayList<String>  = arrayListOf(),
                            @SerializedName("Teams"       ) var Teams       : Teams?             = Teams(),
                            @SerializedName("Innings"     ) var Innings     : ArrayList<Innings> = arrayListOf(),
):java.io.Serializable