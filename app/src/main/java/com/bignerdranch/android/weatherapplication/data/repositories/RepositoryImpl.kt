package com.bignerdranch.android.weatherapplication.data.repositories

import android.util.Log
import com.bignerdranch.android.weatherapplication.data.manager.DataManager
import com.bignerdranch.android.weatherapplication.data.models.Country
import com.bignerdranch.android.weatherapplication.data.models.CountryResponseData
import com.bignerdranch.android.weatherapplication.data.models.WeatherResponseData
import com.bignerdranch.android.weatherapplication.data.repositories.country.CacheCountryDataStore
import com.bignerdranch.android.weatherapplication.data.repositories.country.RemoteCountryDataStore
import com.bignerdranch.android.weatherapplication.data.repositories.weather.RemoteWeatherDataStore
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val cacheCountryDataStore: CacheCountryDataStore,
    private val remoteCountryDataStore: RemoteCountryDataStore,
    private val dataManager: DataManager,
    private val weatherDataStore: RemoteWeatherDataStore
) : Repository {

    override fun loadCountry(): List<Country> {
        return dataManager.getCountry()
    }

    override fun loadCountryFromApi(): Single<List<CountryResponseData>> {
        val listCountries = remoteCountryDataStore.get()
        Log.d("CheckProblem", "listCountries = $listCountries")
        return listCountries
    }

    override suspend fun getTemp(
        lat: String,
        lon: String,
        exclude: String,
        appId: String
    ): WeatherResponseData? {
        return weatherDataStore.getTemp(lat = lat, lon = lon, exclude = exclude, appId = appId)
    }


}