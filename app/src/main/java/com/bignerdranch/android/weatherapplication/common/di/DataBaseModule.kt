package com.bignerdranch.android.weatherapplication.common.di

import android.app.Application
import androidx.room.Room
import com.bignerdranch.android.weatherapplication.common.db.AppDataBase
import com.bignerdranch.android.weatherapplication.common.db.DataBaseHelper
import com.bignerdranch.android.weatherapplication.common.db.DataBaseHelperImpl
import com.bignerdranch.android.weatherapplication.data.repositories.country.CacheCountryDataStore
import com.bignerdranch.android.weatherapplication.data.repositories.country.CacheCountryDataStoreImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDataBase {
        return Room.databaseBuilder(application, AppDataBase::class.java, "database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideHelperDatabase(appDatabase: AppDataBase): DataBaseHelper {
        return DataBaseHelperImpl(appDatabase)
    }

    @Provides
    fun getCacheCountryDataStore(dbHelper: DataBaseHelper): CacheCountryDataStore {
        return CacheCountryDataStoreImpl(dbHelper)
    }

}