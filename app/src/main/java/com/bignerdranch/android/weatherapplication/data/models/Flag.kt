package com.bignerdranch.android.weatherapplication.data.models

import com.google.gson.annotations.SerializedName

data class Flag(

    @SerializedName("png")
    val flagURL: String

)
