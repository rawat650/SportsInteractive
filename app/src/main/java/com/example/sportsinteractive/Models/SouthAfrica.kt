package com.example.sportsinteractive.Models

import com.google.gson.annotations.SerializedName

data class SouthAfrica(@SerializedName("Name_Full"  ) var NameFull  : String?  = null,
                       @SerializedName("Name_Short" ) var NameShort : String?  = null,
                       @SerializedName("Players"    ) var Player   : Map<String,PlayerDetail>? = null) : java.io.Serializable
