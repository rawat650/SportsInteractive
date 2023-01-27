package com.example.sportsinteractive.Models

import com.google.gson.annotations.SerializedName

data class Teams (

    @SerializedName("6" ) var south_africa : SouthAfrica? = SouthAfrica(),
    @SerializedName("7" ) var pak : Pak? = Pak(),
    @SerializedName("4") var nz: Nz? = null,
    @SerializedName("5") var ind: Ind? = null

) : java.io.Serializable