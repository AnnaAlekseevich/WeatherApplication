package com.bignerdranch.android.weatherapplication.ui.fragments.filter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import moxy.MvpPresenter
import kotlin.coroutines.CoroutineContext

class FilterPresenter : MvpPresenter<FilterContract>() {

    private val presenterScope: CoroutineScope by lazy {
        val context: CoroutineContext = Dispatchers.Main.plus(SupervisorJob(null))
        CoroutineScope(context)
    }


}