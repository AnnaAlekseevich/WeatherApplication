package com.bignerdranch.android.weatherapplication.common.rx

import androidx.databinding.ObservableBoolean
import com.bignerdranch.android.weatherapplication.common.util.Constants
import io.reactivex.rxjava3.observers.DisposableSingleObserver

abstract class CustomSingleObserver<T>(
    private var isProgress: ObservableBoolean? = null,
    private var onErrorListener: OnErrorListener? = null
) : DisposableSingleObserver<T>() {

    override fun onStart() {
        super.onStart()
        isProgress?.set(true)
    }

    override fun onSuccess(result: T) {
        isProgress?.set(false)
    }

    override fun onError(e: Throwable) {
        onErrorListener?.onError(
            message = e.message ?: Constants.UNKNOWN_ERROR
        ) ?: run {
            isProgress?.set(false)
        }
    }
}