package com.bignerdranch.android.weatherapplication.data.models

import com.google.gson.annotations.SerializedName

data class WeatherResponseData(

    @SerializedName("current")
    val currentWeather: CurrentWeather

)
