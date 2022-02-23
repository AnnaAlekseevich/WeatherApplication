package com.bignerdranch.android.weatherapplication.ui.fragments.country

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bignerdranch.android.weatherapplication.data.models.CountryResponseData
import com.bignerdranch.android.weatherapplication.data.repositories.Repository
import com.bignerdranch.android.weatherapplication.ui.fragments.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(repository: Repository): BaseViewModel() {

    var data : List<CountryResponseData>? = null

    val countriesList = MutableLiveData<List<CountryResponseData>>()

    init {
        repository.loadCountryFromApi()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { res ->
                countriesList.postValue(res)
                Log.d("CheckProblem", "res = $res")
                data = res
            }
    }

}