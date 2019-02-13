package com.bitecode.autobite.screens.history.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitecode.autobite.AutoBiteApp
import com.bitecode.autobite.di.history.HistoryModule
import com.bitecode.autobite.screens.shared.data.repo.TripRepository
import javax.inject.Inject

class HistoryViewModelFactory : ViewModelProvider.Factory {

    @Inject
    lateinit var tripRepository: TripRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        AutoBiteApp.appComponent.newHistoryComponent(HistoryModule()).inject(this)
        return HistoryViewModel(tripRepository) as T
    }
}