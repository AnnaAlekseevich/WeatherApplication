package com.bignerdranch.android.weatherapplication.data.manager

import android.content.Context
import android.util.Log
import com.bignerdranch.android.weatherapplication.R
import com.bignerdranch.android.weatherapplication.common.util.CountryUtils
import com.bignerdranch.android.weatherapplication.data.models.Country
import com.google.gson.Gson
import io.reactivex.rxjava3.core.Single
import javax.inject.Singleton

@Singleton
class DataManagerImpl(private val context: Context, private val gson: Gson): DataManager {

    override fun getStringFromResources(resId: Int): String {
        return context.getString(resId)
    }

    override fun getCountry(): List<Country> {
        return getCountryData()
    }

    private fun getCountryData(): List<Country>{
        val countryStubList = mutableListOf<Country>()

        for (i in countriesImages.indices){
            Log.d("CheckProblem", "i = $i")
            countryStubList.add(i, (Country(countryName = countriesNames[i], capitalName = capitalsNames[i], imageResId = countriesImages[i])))
        }
        Log.d("CheckProblem", "countriesImages.size = ${countriesImages.size}")
        Log.d("CheckProblem", "countriesImages[0] = ${countriesImages[0]}")
        Log.d("CheckProblem", "countriesImages = $countriesImages")
        Log.d("CheckProblem", "countriesNames = $countriesNames")
        Log.d("CheckProblem", "capitalsNames = $capitalsNames")
        Log.d("CheckProblem", "countryStubList = $countryStubList")
        return countryStubList
    }

    private val countriesImages: List<Int>
        get() = CountryUtils.getCountryImages

    private val countriesNames: List<String>
        get() = listOf(
            getStringFromResources(R.string.country_Germany),
            getStringFromResources(R.string.country_Austria),
            getStringFromResources(R.string.country_France),
            getStringFromResources(R.string.country_Italy),
            getStringFromResources(R.string.country_Switzerland)
        )

    private val capitalsNames: List<String>
        get() = listOf(
            getStringFromResources(R.string.capital_Germany),
            getStringFromResources(R.string.capital_Austria),
            getStringFromResources(R.string.capital_France),
            getStringFromResources(R.string.capital_Italy),
            getStringFromResources(R.string.capital_Switzerland)
        )


}