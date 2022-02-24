package com.bignerdranch.android.weatherapplication.ui.fragments.filter

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface FilterContract : MvpView {

    fun showToast(toastText: String)
    fun showProgressBar(loading: Boolean)

    fun onShowLog(log: String)

}