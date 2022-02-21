package com.bignerdranch.android.weatherapplication.data.repositories.country

import android.util.Log
import com.bignerdranch.android.weatherapplication.data.manager.DataManager
import com.bignerdranch.android.weatherapplication.data.models.Country
import com.bignerdranch.android.weatherapplication.data.models.CountryApi
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryRepositoryImpl @Inject constructor(
    private val cacheCountryDataStore: CacheCountryDataStore,
    private val remoteCountryDataStore: RemoteCountryDataStore,
    private val dataManager: DataManager
) : CountryRepository {

    override fun loadCountry(): List<Country> {
        return dataManager.getCountry()
    }

    override fun loadCountryFromApi(): Single<List<CountryApi>> {
        val listCountries = remoteCountryDataStore.get()
        Log.d("CheckProblem", "listCountries = $listCountries")
        return listCountries
    }


}