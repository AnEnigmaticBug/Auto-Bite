package com.bitecode.autobite.screens.tripdetails.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitecode.autobite.screens.shared.data.repo.TripRepository
import com.bitecode.autobite.screens.shared.util.asMut
import com.bitecode.autobite.screens.shared.util.set
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TripDetailsViewModel(id: Long, tRepo: TripRepository) : ViewModel() {

    val orderData: LiveData<UiOrder> = MutableLiveData()


    private val d1 = CompositeDisposable()


    init {
        d1.set(tRepo.getTripById(id)
            .map { trip -> UiOrder.ShowWorking(trip) }
            .subscribeOn(Schedulers.io())
            .subscribe(
                { order ->
                    orderData.asMut().postValue(order)
                },
                {

                }
            ))
    }


    override fun onCleared() {
        super.onCleared()
        d1.clear()
    }
}