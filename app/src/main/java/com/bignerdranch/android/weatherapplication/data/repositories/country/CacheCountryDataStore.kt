package com.bignerdranch.android.weatherapplication.data.repositories.country

import com.bignerdranch.android.weatherapplication.data.models.Country

interface CacheCountryDataStore {

    fun get(): List<Country>
    fun save(countries: List<Country>)
//    fun reset()
//    fun refresh(countries: List<Country>)
}