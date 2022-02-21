package com.bignerdranch.android.weatherapplication.ui.fragments

import android.util.Log
import com.bignerdranch.android.weatherapplication.data.models.CountryApi
import com.bignerdranch.android.weatherapplication.data.repositories.country.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(repository: CountryRepository): BaseViewModel() {

var data : List<CountryApi>? = null

    init {
        repository.loadCountryFromApi()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { res ->
                Log.d("CheckProblem", "res = $res")
                data = res
            }
    }

    //todo -> create liveData and subscribe to it in Fragment

}