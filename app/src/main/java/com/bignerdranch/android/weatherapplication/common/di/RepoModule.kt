package com.bignerdranch.android.weatherapplication.common.di

import com.bignerdranch.android.weatherapplication.data.manager.DataManager
import com.bignerdranch.android.weatherapplication.data.repositories.country.CacheCountryDataStore
import com.bignerdranch.android.weatherapplication.data.repositories.country.CountryRepository
import com.bignerdranch.android.weatherapplication.data.repositories.country.CountryRepositoryImpl
import com.bignerdranch.android.weatherapplication.data.repositories.country.RemoteCountryDataStore
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
        dataManager: DataManager
    ): CountryRepository {
        return CountryRepositoryImpl(cacheCountryDataStore, remoteCountryDataStore, dataManager)
    }

}