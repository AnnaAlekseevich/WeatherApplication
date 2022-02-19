package com.bignerdranch.android.weatherapplication.data.repositories.country

import com.bignerdranch.android.weatherapplication.common.db.DataBaseHelper
import com.bignerdranch.android.weatherapplication.data.models.Country

class CacheCountryDataStoreImpl (private val dbHelper: DataBaseHelper): CacheCountryDataStore {
    override fun get(): List<Country> {
        return dbHelper.getCountry()
    }

    override fun save(countries: List<Country>) {
        dbHelper.insertAll(countries)
    }

//    override fun reset() {
//        dbHelper.deleteAll()
//    }
//
//    override fun refresh(countries: List<Country>) {
//        dbHelper.deleteAll()
//        return dbHelper.insertAll(countries)
//    }
}