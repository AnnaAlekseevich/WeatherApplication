package com.bignerdranch.android.weatherapplication.common.db

import com.bignerdranch.android.weatherapplication.data.models.Country

interface DataBaseHelper {

    fun getCountry() : List<Country>

    fun insertAll(countries: List<Country>)

    fun update(country: Country)

    fun updateUser(country: Country)

//    fun deleteAll()

}