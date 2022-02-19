package com.bignerdranch.android.weatherapplication.common.di

import com.bignerdranch.android.weatherapplication.data.repositories.country.CountryRepository
import com.bignerdranch.android.weatherapplication.data.repositories.country.CountryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindingModule {

    @Binds
    abstract fun repository(repository: CountryRepositoryImpl): CountryRepository

}