package com.bignerdranch.android.weatherapplication.common.db

import androidx.room.*
import com.bignerdranch.android.weatherapplication.data.models.Country

@Dao
interface CountryDao {

    @Query("SELECT * FROM country")
    fun getCountry() : List<Country>

    @Insert
    fun insertAll(countries: List<Country>)

    @Update
    fun update(country: Country)

//    @Delete
//    fun deleteAll()


}