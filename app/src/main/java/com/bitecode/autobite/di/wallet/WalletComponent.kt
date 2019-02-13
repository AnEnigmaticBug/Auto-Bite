package com.bitecode.autobite.di.wallet

import com.bitecode.autobite.screens.wallet.core.WalletViewModelFactory
import dagger.Subcomponent

@Subcomponent(modules = [WalletModule::class])
interface WalletComponent {

    fun inject(factory: WalletViewModelFactory)
}