package com.bignerdranch.android.weatherapplication.common.di

import com.bignerdranch.android.weatherapplication.common.net.ApiCountry
import com.bignerdranch.android.weatherapplication.data.repositories.country.RemoteCountryDataStore
import com.bignerdranch.android.weatherapplication.data.repositories.country.RemoteCountryDataStoreImpl
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {

    fun getApiServiceCountry(): Retrofit {

        val builder = GsonBuilder()
        val httpClient = OkHttpClient.Builder()
        val gson = builder.create()
        val logging = HttpLoggingInterceptor()

        return Retrofit.Builder()
            .baseUrl("https://restcountries.com/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(
                httpClient.addInterceptor(
                    logging.setLevel(
                        HttpLoggingInterceptor.Level.BODY
                    )
                )
                    .build()
            )
            .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideApiCountry(): ApiCountry =
        getApiServiceCountry().create(ApiCountry::class.java)

    @Provides
    fun getRemoteCountryDataStore(apiCountry: ApiCountry): RemoteCountryDataStore {
        return RemoteCountryDataStoreImpl(apiCountry)
    }

}