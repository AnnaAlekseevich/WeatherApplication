package com.bignerdranch.android.weatherapplication.data.repositories.country

import com.bignerdranch.android.weatherapplication.R
import com.bignerdranch.android.weatherapplication.data.models.Country

class RemoteCountryDataStoreImpl: RemoteCountryDataStore {

    override fun get(): List<Country> {
        val remoteCountryList = mutableListOf<Country>()
        remoteCountryList.add(Country("Belarus", "Minsk", R.drawable.ic_flag_unknown))
        remoteCountryList.add(Country("Russia", "Moscow", R.drawable.ic_flag_unknown))
        return remoteCountryList
    }

}