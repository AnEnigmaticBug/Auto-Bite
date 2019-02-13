package com.bitecode.autobite.di.shared

import com.bitecode.autobite.di.history.HistoryComponent
import com.bitecode.autobite.di.history.HistoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newHistoryComponent(m1: HistoryModule): HistoryComponent
}