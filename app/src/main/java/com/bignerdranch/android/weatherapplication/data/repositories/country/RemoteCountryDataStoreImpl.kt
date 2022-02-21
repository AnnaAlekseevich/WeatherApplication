package com.bignerdranch.android.weatherapplication.data.repositories.country

import android.util.Log
import com.bignerdranch.android.weatherapplication.common.net.ApiCountry
import com.bignerdranch.android.weatherapplication.data.models.CountryApi
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteCountryDataStoreImpl @Inject constructor(private val apiCountry: ApiCountry) :
    RemoteCountryDataStore {

    override fun get(): Single<List<CountryApi>> {

        return apiCountry.getCountries()
            .subscribeOn(Schedulers.io())

    }

}