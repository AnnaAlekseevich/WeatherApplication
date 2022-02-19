package com.bignerdranch.android.weatherapplication.common.net

import com.bignerdranch.android.weatherapplication.data.models.CountryResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCountry {

    @GET("api/v1/rovers/curiosity/photos")
    fun getPhotos(
        @Query("earth_date") earth_date: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String
    ): Single<CountryResponse>

}