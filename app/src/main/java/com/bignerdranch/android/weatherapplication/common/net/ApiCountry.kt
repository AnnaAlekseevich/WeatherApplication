package com.bignerdranch.android.weatherapplication.common.net

import com.bignerdranch.android.weatherapplication.data.models.CountiesListApiResponse
import com.bignerdranch.android.weatherapplication.data.models.CountryApi
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiCountry {

    @GET("/v2/all?fields=name,capital,currencies")
    fun getCountries(): Single<List<CountryApi>>

}