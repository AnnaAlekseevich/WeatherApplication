package com.bignerdranch.android.weatherapplication.data.repositories

import com.bignerdranch.android.weatherapplication.data.models.Country
import com.bignerdranch.android.weatherapplication.data.models.CountryResponseData
import com.bignerdranch.android.weatherapplication.data.models.WeatherResponseData
import io.reactivex.rxjava3.core.Single

interface Repository {

    //    fun getCoins(): List<Country>
    fun loadCountry(): List<Country>

    fun loadCountryFromApi(): Single<List<CountryResponseData>>

    suspend fun getTemp(
        lat: String,
        lon: String,
        exclude: String,
        appId: String
    ): WeatherResponseData?

    suspend fun getExampleResponse(appId: String): WeatherResponseData?
}