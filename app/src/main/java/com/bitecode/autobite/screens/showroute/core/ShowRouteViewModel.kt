package com.bitecode.autobite.screens.showroute.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitecode.autobite.screens.shared.data.repo.RickshawRepository
import com.bitecode.autobite.screens.shared.util.asMut
import com.bitecode.autobite.screens.shared.util.set
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ShowRouteViewModel(private val rRepo: RickshawRepository) : ViewModel() {

    val orderData: LiveData<UiOrder> = MutableLiveData()
    val toastData: LiveData<String?> = MutableLiveData()


    private var isAutoAllotted = false
    private var lat = 0.0
    private var lng = 0.0

    private val d1 = CompositeDisposable()
    private val d2 = CompositeDisposable()


    init {
        orderData.asMut().value = UiOrder.ShowLoading
    }


    fun initializeForLocation(lat: Double, lng: Double) {
        this.lat = lat
        this.lng = lng

        toastData.asMut().value = "Getting rickshaws near you"
        d1.set(rRepo.getRickshawsNearLocation(lat, lng)
            .map { rickshaws -> UiOrder.ShowCloseByRickshaws(rickshaws) }
            .subscribeOn(Schedulers.io())
            .subscribe(
                { order ->
                    if(!isAutoAllotted) {
                        orderData.asMut().postValue(order)
                    }
                },
                {
                    toastData.asMut().postValue("Something went wrong :/")
                }
            ))
    }

    fun callRickshaw() {
        toastData.asMut().value = "Attempting to call a rickshaw"
        d2.set(rRepo.callRickshaw(lat, lng)
            .map { rickshaw -> UiOrder.ShowAllottedRickshaw(rickshaw) }
            .subscribeOn(Schedulers.io())
            .subscribe(
                { order ->
                    isAutoAllotted = true
                    orderData.asMut().postValue(order)
                    toastData.asMut().postValue("A rickshaw has been allotted")
                },
                {
                    toastData.asMut().postValue("Something went wrong :/")
                }
            ))
    }


    override fun onCleared() {
        super.onCleared()
        d1.clear()
        d2.clear()
    }
}