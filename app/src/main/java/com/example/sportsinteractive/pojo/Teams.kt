package com.example.sportsinteractive.pojo

import com.google.gson.annotations.SerializedName

data class Teams (

    @SerializedName("6" ) var south_africa : south_africa? = south_africa(),
    @SerializedName("7" ) var pak : pak? = pak(),
    @SerializedName("4") var nz: Nz? = null,
    @SerializedName("5") var ind: Ind? = null

) : java.io.Serializable