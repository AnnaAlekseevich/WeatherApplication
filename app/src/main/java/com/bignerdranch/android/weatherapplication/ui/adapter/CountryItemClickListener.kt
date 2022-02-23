package com.bignerdranch.android.weatherapplication.ui.adapter

import com.bignerdranch.android.weatherapplication.data.models.CountryResponseData

interface CountryItemClickListener {
    fun onCountryClicked(country: CountryResponseData)
}