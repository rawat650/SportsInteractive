package com.example.sportsinteractive.Models

import com.google.gson.annotations.SerializedName

data class Pak(@SerializedName("Name_Full"  ) var NameFull  : String?  = null,
               @SerializedName("Name_Short" ) var NameShort : String?  = null,
               @SerializedName("Players"    ) var Players   : Map<String,PlayerDetail>? = null):java.io.Serializable