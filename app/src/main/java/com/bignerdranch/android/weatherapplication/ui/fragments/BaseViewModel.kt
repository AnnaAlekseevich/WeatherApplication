package com.bignerdranch.android.weatherapplication.ui.fragments

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.weatherapplication.common.rx.CustomSingleObserver
import com.bignerdranch.android.weatherapplication.common.rx.OnErrorListener
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver

abstract class BaseViewModel: ViewModel() {

    private val disposables = CompositeDisposable()

    var isProgress: ObservableBoolean = ObservableBoolean()

    var onErrorListener: OnErrorListener? = null

    protected fun processTask(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun <T> simpleSingleObserver(onSuccess: (result: T) -> Unit): DisposableSingleObserver<T> {
        return object : CustomSingleObserver<T>(isProgress, onErrorListener) {
            override fun onSuccess(result: T) {
                onSuccess(result)
            }
        }
    }

}