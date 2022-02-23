package com.bignerdranch.android.weatherapplication.data.repositories.weather

import com.bignerdranch.android.weatherapplication.common.net.ApiWeather
import com.bignerdranch.android.weatherapplication.data.models.WeatherResponseData
import javax.inject.Inject

class RemoteWeatherDataStoreImpl @Inject constructor(private val apiWeather: ApiWeather) :
    RemoteWeatherDataStore {

    override suspend fun getTemp(
        lat: String,
        lon: String,
        exclude: String,
        appId: String
    ): WeatherResponseData? {
        return apiWeather.getWeather(lat = lat, lon = lon, part = exclude, apiKey = appId).body()
    }

}