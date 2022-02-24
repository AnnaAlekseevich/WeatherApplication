package com.bignerdranch.android.weatherapplication.common.net

import com.bignerdranch.android.weatherapplication.data.models.WeatherResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiWeather {

    @GET("data/2.5/onecall")
    suspend fun getWeather(
        @Query("lat") lat: String, @Query("lon") lon: String, @Query("exclude") part: String,
        @Query("appid") apiKey: String
    ): Response<WeatherResponseData>

    @GET("data/2.5/onecall")
    suspend fun getWeather(@Query("appid") apiKey: String): Response<WeatherResponseData>

}