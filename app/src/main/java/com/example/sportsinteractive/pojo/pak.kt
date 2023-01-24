package com.example.sportsinteractive.pojo

import com.google.gson.annotations.SerializedName

data class pak(@SerializedName("Name_Full"  ) var NameFull  : String?  = null,
               @SerializedName("Name_Short" ) var NameShort : String?  = null,
               @SerializedName("Players"    ) var Players   : Map<String,PlayerDetail>? = null):java.io.Serializable