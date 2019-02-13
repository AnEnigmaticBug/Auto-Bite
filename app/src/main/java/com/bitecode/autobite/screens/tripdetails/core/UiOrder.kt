package com.bitecode.autobite.screens.tripdetails.core

import com.bitecode.autobite.screens.shared.core.Trip

sealed class UiOrder {

    data class ShowWorking(val trip: Trip) : UiOrder()
}