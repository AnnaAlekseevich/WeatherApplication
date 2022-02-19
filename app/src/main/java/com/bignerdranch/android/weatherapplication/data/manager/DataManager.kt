package com.bignerdranch.android.weatherapplication.data.manager

import androidx.annotation.StringRes
import com.bignerdranch.android.weatherapplication.data.models.Country
import io.reactivex.rxjava3.core.Single

interface DataManager {

    fun getStringFromResources(@StringRes resId: Int): String

    fun getCountry(): List<Country>

}