package com.bitecode.autobite.screens.shared.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun <T> LiveData<T>.asMut(): MutableLiveData<T> {
    return when(this) {
        is MutableLiveData -> this
        else               -> throw IllegalArgumentException("Not a MutableLiveData")
    }
}

fun CompositeDisposable.set(disposable: Disposable) {
    clear()
    add(disposable)
}