package com.bignerdranch.android.weatherapplication.data.repositories.country

import com.bignerdranch.android.weatherapplication.data.manager.DataManager
import com.bignerdranch.android.weatherapplication.data.models.Country
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryRepositoryImpl @Inject constructor(
    private val cacheCountryDataStore: CacheCountryDataStore,
//    private val remoteCountryDataStore: RemoteCountryDataStore,
    private val dataManager: DataManager
) : CountryRepository {

    override fun loadCountry(): List<Country> {
        return dataManager.getCountry()
    }


}