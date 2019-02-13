package com.bitecode.autobite.screens.wallet.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitecode.autobite.AutoBiteApp
import com.bitecode.autobite.di.wallet.WalletModule
import com.bitecode.autobite.screens.shared.data.repo.UserRepository
import javax.inject.Inject

class WalletViewModelFactory : ViewModelProvider.Factory {

    @Inject
    lateinit var userRepository: UserRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        AutoBiteApp.appComponent.newWalletComponent(WalletModule()).inject(this)
        return WalletViewModel(userRepository) as T
    }
}