package com.bignerdranch.android.weatherapplication.ui.adapter

import com.bignerdranch.android.weatherapplication.data.models.CountryApi

interface CountryItemClickListener {
    fun onCountryClicked(country: CountryApi)
}