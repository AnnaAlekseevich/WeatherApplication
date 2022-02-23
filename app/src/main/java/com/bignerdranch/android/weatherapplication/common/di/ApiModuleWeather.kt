package com.bignerdranch.android.weatherapplication.common.di

import com.bignerdranch.android.weatherapplication.common.net.ApiWeather
import com.bignerdranch.android.weatherapplication.data.repositories.weather.RemoteWeatherDataStore
import com.bignerdranch.android.weatherapplication.data.repositories.weather.RemoteWeatherDataStoreImpl
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
object ApiModuleWeather {


    fun getApiServiceWeather(): Retrofit {

        val builder = GsonBuilder()
        val httpClient = OkHttpClient.Builder()
        val gson = builder.create()
        val logging = HttpLoggingInterceptor()

        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
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
    fun provideApiWeather(): ApiWeather =
        getApiServiceWeather().create(ApiWeather::class.java)

    @Provides
    fun getRemoteWeatherDataStore(apiWeather: ApiWeather): RemoteWeatherDataStore {
        return RemoteWeatherDataStoreImpl(apiWeather)
    }

}