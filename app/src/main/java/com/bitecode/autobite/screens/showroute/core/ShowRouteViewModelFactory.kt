package com.bitecode.autobite.screens.showroute.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitecode.autobite.AutoBiteApp
import com.bitecode.autobite.di.showroute.ShowRouteModule
import com.bitecode.autobite.screens.shared.data.repo.RickshawRepository
import javax.inject.Inject

class ShowRouteViewModelFactory : ViewModelProvider.Factory {

    @Inject
    lateinit var rickshawRepository: RickshawRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        AutoBiteApp.appComponent.newShowRouteComponent(ShowRouteModule()).inject(this)
        return ShowRouteViewModel(rickshawRepository) as T
    }
}