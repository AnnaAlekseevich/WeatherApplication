package com.bignerdranch.android.weatherapplication.data.repositories.country

import com.bignerdranch.android.weatherapplication.data.manager.DataManager
import com.bignerdranch.android.weatherapplication.data.models.Country
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryRepositoryImpl @Inject constructor(private val dataManager: DataManager,): CountryRepository {

    //    override fun getCoins(): List<Country> {
//        TODO("Not yet implemented")
//    }
    override fun loadCountry(): Single<List<Country>> {
        return dataManager.getCountry()
    }

}