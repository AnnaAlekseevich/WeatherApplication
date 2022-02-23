package com.bignerdranch.android.weatherapplication.data.repositories.country

import com.bignerdranch.android.weatherapplication.data.models.CountryResponseData
import io.reactivex.rxjava3.core.Single

interface RemoteCountryDataStore {

    fun get(): Single<List<CountryResponseData>>
}