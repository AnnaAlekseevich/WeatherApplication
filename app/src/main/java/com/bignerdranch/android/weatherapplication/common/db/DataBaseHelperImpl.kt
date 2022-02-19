package com.bignerdranch.android.weatherapplication.common.db

import com.bignerdranch.android.weatherapplication.data.models.Country

class DataBaseHelperImpl(private val appDataBase: AppDataBase): DataBaseHelper {

    override fun getCountry(): List<Country> {
        return appDataBase.countryDao().getCountry()
    }

    override fun insertAll(countries: List<Country>) {
        return appDataBase.countryDao().insertAll(countries = countries)
    }

    override fun update(country: Country) {
        return appDataBase.countryDao().update(country = country)
    }

    override fun updateUser(country: Country) {
        return appDataBase.countryDao().update(country = country)
    }

//    override fun deleteAll() {
//        return appDataBase.countryDao().deleteAll()
//    }
}