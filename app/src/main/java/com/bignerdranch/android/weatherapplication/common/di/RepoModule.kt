package com.bignerdranch.android.weatherapplication.common.di

import com.bignerdranch.android.weatherapplication.data.manager.DataManager
import com.bignerdranch.android.weatherapplication.data.repositories.country.CacheCountryDataStore
import com.bignerdranch.android.weatherapplication.data.repositories.Repository
import com.bignerdranch.android.weatherapplication.data.repositories.RepositoryImpl
import com.bignerdranch.android.weatherapplication.data.repositories.country.RemoteCountryDataStore
import com.bignerdranch.android.weatherapplication.data.repositories.weather.RemoteWeatherDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepoModule {

    @JvmStatic
    @Singleton
    @Provides
    fun getCountryRepository(
        cacheCountryDataStore: CacheCountryDataStore,
        remoteCountryDataStore: RemoteCountryDataStore,
        dataManager: DataManager,
        remoteWeatherDataStore: RemoteWeatherDataStore
    ): Repository {
        return RepositoryImpl(cacheCountryDataStore, remoteCountryDataStore, dataManager, remoteWeatherDataStore)
    }

}