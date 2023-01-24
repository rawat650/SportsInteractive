package com.example.sportsinteractive.pojo

import com.google.gson.annotations.SerializedName

data class Players (@SerializedName("Players") val  player :  List<Map<String,PlayerDetail>>):java.io.Serializable
data class PlayerDetail (
    @SerializedName("Position"  ) var Position : String?  = null,
    @SerializedName("Name_Full" ) var NameFull : String?  = null,
/*@SerializedName("IsKeeper") var isKeepr: Boolean = false,
@SerializedName("Batting") var batting : Batting? = null,
@SerializedName("Bowling") var batting : Bowling? = null,*/) :java.io.Serializable

