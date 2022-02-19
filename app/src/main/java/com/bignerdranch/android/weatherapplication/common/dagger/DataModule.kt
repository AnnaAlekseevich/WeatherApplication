package com.bignerdranch.android.weatherapplication.common.dagger

import android.content.Context
import com.bignerdranch.android.weatherapplication.data.manager.DataManager
import com.bignerdranch.android.weatherapplication.data.manager.DataManagerImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDataManager(@ApplicationContext context: Context, gson: Gson): DataManager {
            return DataManagerImpl(context, gson)
    }

    @Provides
    fun provideGson() = Gson()

}