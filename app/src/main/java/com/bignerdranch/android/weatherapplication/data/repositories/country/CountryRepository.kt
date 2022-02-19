package com.bignerdranch.android.weatherapplication.data.repositories.country

import com.bignerdranch.android.weatherapplication.data.models.Country
import io.reactivex.rxjava3.core.Single

interface CountryRepository {

//    fun getCoins(): List<Country>
    fun loadCountry(): Single<List<Country>>
}