package com.bitecode.autobite.screens.shared.data.repo

import com.bitecode.autobite.screens.shared.core.Trip
import io.reactivex.Completable
import io.reactivex.Flowable
import org.threeten.bp.LocalDateTime

class TripRepositoryImpl : TripRepository {

    override fun getTrips(): Flowable<List<Trip>> {
        val now = LocalDateTime.now()
        return Flowable.just(
            listOf(
                Trip(1, "Ram Bhawan", "Bus Stand", 40, 3.5f, now.minusDays(1)),
                Trip(2, "Srinivasa Ramanujan Bhawan", "Pizzeria", 60, 4.4f, now.minusDays(4)),
                Trip(3, "Gandhi Bhawan", "Krishna Bhawan", 90, 0.3f, now.minusDays(5)),
                Trip(4, "FD II", "Vishwakarma Bhawan", 15, 0.4f, now.minusDays(9))
            )
        )
    }

    override fun addTrip(trip: Trip): Completable {
        return Completable.complete()
    }
}