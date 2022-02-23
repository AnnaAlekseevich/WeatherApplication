package com.bignerdranch.android.weatherapplication.data.models

import com.google.gson.annotations.SerializedName

data class CurrentWeather(

    @SerializedName("temp")
    val temp: String

)
