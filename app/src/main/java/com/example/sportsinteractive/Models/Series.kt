package com.example.sportsinteractive.Models

import com.google.gson.annotations.SerializedName

data class Series (

    @SerializedName("Id"        ) var Id       : String? = null,
    @SerializedName("Name"      ) var Name     : String? = null,
    @SerializedName("Status"    ) var Status   : String? = null,
    @SerializedName("Tour"      ) var Tour     : String? = null,
    @SerializedName("Tour_Name" ) var TourName : String? = null

)