package com.bignerdranch.android.weatherapplication.ui.fragments

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.weatherapplication.data.models.Country
import com.bignerdranch.android.weatherapplication.data.repositories.country.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(private val repository: CountryRepository): BaseViewModel() {

    val listData = repository.loadCountry()

    fun checkData(){
        Log.d("CheckProblem", "loadCountry() = ${repository.loadCountry()}")
    }






}