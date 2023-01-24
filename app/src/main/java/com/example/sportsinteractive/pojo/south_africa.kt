package com.example.sportsinteractive.pojo

import com.google.gson.annotations.SerializedName

data class south_africa(@SerializedName("Name_Full"  ) var NameFull  : String?  = null,
                        @SerializedName("Name_Short" ) var NameShort : String?  = null,
                    @SerializedName("Players"    ) var Player   : Map<String,PlayerDetail>? = null) : java.io.Serializable
