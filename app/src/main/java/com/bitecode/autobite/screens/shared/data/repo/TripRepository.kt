package com.bitecode.autobite.screens.shared.data.repo

import com.bitecode.autobite.screens.shared.core.Trip
import io.reactivex.Completable
import io.reactivex.Flowable

interface TripRepository {

    /**
     * Gives the trips undertaken by the user in descending order of datetime.
     * */
    fun getTrips(): Flowable<List<Trip>>

    /**
     * Gives the trip having id equal to the passed-in id.
     * */
    fun getTripById(id: Long): Flowable<Trip>

    /**
     * Adds the trip to the database. The passed-in object's id is irrelevant.
     * */
    fun addTrip(trip: Trip): Completable
}