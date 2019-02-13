package com.bitecode.autobite.screens.history.core

import com.bitecode.autobite.screens.shared.core.Trip

sealed class UiOrder {

    data class ShowWorking(val trips: List<Trip>) : UiOrder()

    data class ShowFailure(val error: String) : UiOrder()
}