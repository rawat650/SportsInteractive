package com.example.sportsinteractive.pojo

import com.google.gson.annotations.SerializedName

data class Teams (

    @SerializedName("6" ) var south_africa : south_africa? = south_africa(),
    @SerializedName("7" ) var pak : pak? = pak()

) : java.io.Serializable