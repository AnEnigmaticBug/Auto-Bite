package com.bitecode.autobite.di.history

import com.bitecode.autobite.screens.history.core.HistoryViewModelFactory
import dagger.Subcomponent

@Subcomponent(modules = [HistoryModule::class])
interface HistoryComponent {

    fun inject(factory: HistoryViewModelFactory)
}