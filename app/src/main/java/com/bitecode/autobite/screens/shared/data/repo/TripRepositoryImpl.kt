package com.bitecode.autobite.screens.shared.data.repo

import com.bitecode.autobite.screens.shared.core.Trip
import com.bitecode.autobite.screens.shared.data.room.TripsDao
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import org.threeten.bp.LocalDateTime

class TripRepositoryImpl(private val tripsDao: TripsDao) : TripRepository {

    init {
        val now = LocalDateTime.now()

        Flowable.fromIterable(listOf(
            Trip(1, "Ram Bhawan", "Bus Stand", 40, 3.5f, now.minusDays(1)),
            Trip(2, "Srinivasa Ramanujan Bhawan", "Pizzeria", 60, 4.4f, now.minusDays(4)),
            Trip(3, "Gandhi Bhawan", "Krishna Bhawan", 90, 0.3f, now.minusDays(5)),
            Trip(4, "FD II", "Vishwakarma Bhawan", 15, 0.4f, now.minusDays(9))
        ))
            .subscribeOn(Schedulers.io())
            .subscribe { trip ->
                tripsDao.addTrip(trip)
            }

    }

    override fun getTrips(): Flowable<List<Trip>> {
        return tripsDao.getTrips()
    }

    override fun getTripById(id: Long): Flowable<Trip> {
        return tripsDao.getTripById(id)
    }

    override fun addTrip(trip: Trip): Completable {
        return Completable.create { _emitter ->
            try {
                tripsDao.addTrip(trip.copy(id = 0L))
                _emitter.onComplete()

            } catch(e: Exception) {
                _emitter.onError(e)
            }
        }
    }
}