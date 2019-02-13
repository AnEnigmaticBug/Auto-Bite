package com.bitecode.autobite.di.tripdetails

import com.bitecode.autobite.screens.tripdetails.core.TripDetailsViewModelFactory
import dagger.Subcomponent

@Subcomponent(modules = [TripDetailsModule::class])
interface TripDetailsComponent {

    fun inject(factory: TripDetailsViewModelFactory)
}