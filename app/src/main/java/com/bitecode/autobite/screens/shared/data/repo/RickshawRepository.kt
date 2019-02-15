package com.bitecode.autobite.screens.shared.data.repo

import com.bitecode.autobite.screens.shared.core.Rickshaw
import io.reactivex.Flowable

interface RickshawRepository {

    /**
     * Gives all the rickshaws in a circle with radius 1km centered at (lat, lng).
     * Rickshaws without any free seats are not given.
     * */
    fun getRickshawsNearLocation(lat: Double, lng: Double): Flowable<List<Rickshaw>>

    /**
     * Attempt to call rickshaw at (lat, lng) and send it's updates if successful.
     * */
    fun callRickshaw(lat: Double, lng: Double): Flowable<Rickshaw>
}