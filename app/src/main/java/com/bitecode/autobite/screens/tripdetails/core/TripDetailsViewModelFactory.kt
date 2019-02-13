package com.bitecode.autobite.screens.tripdetails.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitecode.autobite.AutoBiteApp
import com.bitecode.autobite.di.tripdetails.TripDetailsModule
import com.bitecode.autobite.screens.shared.data.repo.TripRepository
import javax.inject.Inject

class TripDetailsViewModelFactory(private val id: Long) : ViewModelProvider.Factory {

    @Inject
    lateinit var tripRepository: TripRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        AutoBiteApp.appComponent.newTripDetailsComponent(TripDetailsModule()).inject(this)
        return TripDetailsViewModel(id, tripRepository) as T
    }
}