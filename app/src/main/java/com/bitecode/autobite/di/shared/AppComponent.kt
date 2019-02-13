package com.bitecode.autobite.di.shared

import com.bitecode.autobite.di.history.HistoryComponent
import com.bitecode.autobite.di.history.HistoryModule
import com.bitecode.autobite.di.tripdetails.TripDetailsComponent
import com.bitecode.autobite.di.tripdetails.TripDetailsModule
import com.bitecode.autobite.di.wallet.WalletComponent
import com.bitecode.autobite.di.wallet.WalletModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newHistoryComponent(m1: HistoryModule): HistoryComponent

    fun newTripDetailsComponent(m1: TripDetailsModule): TripDetailsComponent

    fun newWalletComponent(m1: WalletModule): WalletComponent
}