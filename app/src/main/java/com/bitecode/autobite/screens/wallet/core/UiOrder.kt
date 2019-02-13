package com.bitecode.autobite.screens.wallet.core

import com.bitecode.autobite.screens.shared.core.User

sealed class UiOrder {

    data class ShowWorking(val user: User) : UiOrder()
}