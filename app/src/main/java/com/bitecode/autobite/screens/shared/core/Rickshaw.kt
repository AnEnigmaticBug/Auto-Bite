package com.bitecode.autobite.screens.shared.core

/**
 * @property lat  is the latitude  of the rickshaw.
 * @property lng  is the longitude of the rickshaw.
 * @property seatsLeft  is the number of seats left in the auto.
 * */
data class Rickshaw(val id: Long, val registrationNumber: String, val lat: Double, val lng: Double, val seatsLeft: Int)