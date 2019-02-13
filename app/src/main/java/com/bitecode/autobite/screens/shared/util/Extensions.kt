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

fun Int.asTwoDigit(): String {
    return when(this) {
        in 0..9   -> "0$this"
        in 10..99 -> this.toString()
        in -9..-1 -> this.toString()
        else      -> throw IllegalArgumentException("Can't represent $this in double digits")
    }
}