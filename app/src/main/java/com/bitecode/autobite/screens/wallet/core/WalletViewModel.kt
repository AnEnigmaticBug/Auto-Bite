package com.bitecode.autobite.screens.wallet.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitecode.autobite.screens.shared.data.repo.UserRepository
import com.bitecode.autobite.screens.shared.util.asMut
import io.reactivex.schedulers.Schedulers

class WalletViewModel(uRepo: UserRepository) : ViewModel() {

    val orderData: LiveData<UiOrder> = MutableLiveData()


    init {
        uRepo.getUser()
            .map { user -> UiOrder.ShowWorking(user) }
            .subscribeOn(Schedulers.io())
            .subscribe(
                { order ->
                    orderData.asMut().postValue(order)
                },
                {

                },
                {

                }
            )
    }
}