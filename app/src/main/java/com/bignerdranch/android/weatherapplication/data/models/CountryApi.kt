package com.bignerdranch.android.weatherapplication.data.models

import com.google.gson.annotations.SerializedName

data class CountryApi(

    @SerializedName("capital")
    val capitalName: List<String>,

    @SerializedName("name")
    val countryName: CountryName,

    @SerializedName("flags")
    val flagUrl: Flag,

    @SerializedName("timezones")
    val timezones: List<String>

)
