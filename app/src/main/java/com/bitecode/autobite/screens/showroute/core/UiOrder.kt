package com.bitecode.autobite.screens.showroute.core

import com.bitecode.autobite.screens.shared.core.Rickshaw

sealed class UiOrder {

    object ShowLoading : UiOrder()

    data class ShowCloseByRickshaws(val rickshaws: List<Rickshaw>) : UiOrder()

    data class ShowAllottedRickshaw(val rickshaw: Rickshaw) : UiOrder()
}