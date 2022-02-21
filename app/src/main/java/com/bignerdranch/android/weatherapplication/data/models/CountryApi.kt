package com.bignerdranch.android.weatherapplication.data.models

import com.google.gson.annotations.SerializedName

data class CountryApi(

    @SerializedName("currencies")
    val currencies: List<Currencies>,
    @SerializedName("name")
    val name: String,
    @SerializedName("capital")
    val capital: String

)
