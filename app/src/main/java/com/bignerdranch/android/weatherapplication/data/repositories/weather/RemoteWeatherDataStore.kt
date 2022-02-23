package com.bignerdranch.android.weatherapplication.data.repositories.weather

import com.bignerdranch.android.weatherapplication.data.models.WeatherResponseData

interface RemoteWeatherDataStore {

    suspend fun getTemp(
        lat: String,
        lon: String,
        exclude: String,
        appId: String
    ): WeatherResponseData?

}