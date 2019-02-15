package com.bitecode.autobite.di.showroute

import com.bitecode.autobite.screens.showroute.core.ShowRouteViewModelFactory
import dagger.Subcomponent

@Subcomponent(modules = [ShowRouteModule::class])
interface ShowRouteComponent {

    fun inject(factory: ShowRouteViewModelFactory)
}