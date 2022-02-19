package com.bignerdranch.android.weatherapplication.common.rx

interface OnErrorListener {
    fun onError(code: String = "", message: String = "unknown error", goBack: Boolean = true)
}