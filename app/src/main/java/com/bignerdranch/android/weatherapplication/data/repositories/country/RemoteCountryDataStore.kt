package com.bignerdranch.android.weatherapplication.data.repositories.country

import com.bignerdranch.android.weatherapplication.data.models.Country

interface RemoteCountryDataStore {

    fun get(): List<Country>
}