package com.bignerdranch.android.weatherapplication.common.net

import com.bignerdranch.android.weatherapplication.data.models.CountryApi
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiCountry {

    @GET("v3.1/all?fields=name,capital,flags,timezones")
    fun getCountries(): Single<List<CountryApi>>

}