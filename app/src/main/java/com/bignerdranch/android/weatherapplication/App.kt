package com.bignerdranch.android.weatherapplication

import android.app.Application
import com.bignerdranch.android.weatherapplication.data.manager.DataManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App: Application() {

    @Inject
    lateinit var dataManager: DataManager

    companion object {
        lateinit var instanceApp: App
    }

    override fun onCreate() {
        super.onCreate()

        instanceApp = this
    }
}