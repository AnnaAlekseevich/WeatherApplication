package com.bignerdranch.android.weatherapplication.ui.fragments

import androidx.lifecycle.ViewModel
import com.bignerdranch.android.weatherapplication.data.models.Country
import com.bignerdranch.android.weatherapplication.data.repositories.country.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(private val repository: CountryRepository): BaseViewModel() {

//    var model: Country
//
//    init {
//        loadCountry()
//    }
//
//    private fun loadCountry(function: (() -> Unit)? = null) {
//        processTask(repository.loadCountry().subscribeWith(simpleSingleObserver {
//            model.set(it)
//            function?.invoke()
//        }))
//    }

}