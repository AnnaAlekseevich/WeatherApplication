package com.bignerdranch.android.weatherapplication.data.repositories.country

import com.bignerdranch.android.weatherapplication.data.models.Country
import com.bignerdranch.android.weatherapplication.data.models.CountryApi
import io.reactivex.rxjava3.core.Single

interface CountryRepository {

//    fun getCoins(): List<Country>
    fun loadCountry(): List<Country>

    fun loadCountryFromApi(): Single<List<CountryApi>>
}