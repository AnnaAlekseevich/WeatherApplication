package com.bignerdranch.android.weatherapplication.ui.adapter

import android.view.View
import com.bignerdranch.android.weatherapplication.data.models.Country

interface CountryItemClickListener {
    fun onCountryClicked(coin: Country?, itemTextView: View)
}