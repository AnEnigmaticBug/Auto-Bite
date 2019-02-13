package com.bitecode.autobite.screens.shared.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bitecode.autobite.screens.shared.core.Trip
import io.reactivex.Flowable

@Dao
interface TripsDao {

    @Query("SELECT * FROM Trips ORDER BY datetime DESC")
    fun getTrips(): Flowable<List<Trip>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTrip(trip: Trip)
}