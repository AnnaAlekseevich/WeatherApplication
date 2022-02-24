package com.bignerdranch.android.weatherapplication.ui.fragments.weather

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.weatherapplication.data.models.WeatherResponseData
import com.bignerdranch.android.weatherapplication.data.repositories.Repository
import com.bignerdranch.android.weatherapplication.ui.fragments.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: Repository
) : BaseViewModel() {

    var exclude: String = "hourly,daily"
    val apiKey = "e4cdcd346b325a197365b48d5e58049e"

    val tempLiveData = MutableLiveData<String>()

    fun loadData(countryLatitude: String, countryLongitude: String) {
        viewModelScope.launch {

            runCatching {

                return@runCatching repository.getTemp(countryLatitude, countryLongitude, exclude, apiKey)
            }
                .onFailure {
                    Log.d("Throwable", "onFailure")
                }.onSuccess {
                    tempLiveData.postValue(it?.currentWeather?.temp)
                    Log.d("CheckDATA", "onSuccess it = ${it?.currentWeather?.temp}")

                }
        }
    }

    fun loadExampleRequest(countryLatitude: String, countryLongitude: String) {
        viewModelScope.launch {
            val tasks = mutableListOf<Deferred<WeatherResponseData?>>()
            for (i in 1..3) {
               val x= async {
                    repository.getTemp(countryLatitude, countryLongitude, exclude, apiKey)
                }
                    tasks.add(x)
                }
            val results = tasks.awaitAll()
            Log.d("CheckExample", "result = $results")
            }
        }



}