package com.bitecode.autobite.screens.history.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitecode.autobite.screens.shared.data.repo.TripRepository
import com.bitecode.autobite.screens.shared.util.asMut
import com.bitecode.autobite.screens.shared.util.set
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HistoryViewModel(tRepo: TripRepository) : ViewModel() {

    val orderData: LiveData<UiOrder> = MutableLiveData()


    private val d1 = CompositeDisposable()


    init {
        d1.set(tRepo.getTrips()
            .map { trips -> UiOrder.ShowWorking(trips) }
            .subscribeOn(Schedulers.io())
            .subscribe(
                { order ->
                    orderData.asMut().postValue(order)
                },
                { error ->
                    orderData.asMut().postValue(UiOrder.ShowFailure("Something went wrong :/"))
                }
            ))
    }


    override fun onCleared() {
        super.onCleared()
        d1.clear()
    }
}