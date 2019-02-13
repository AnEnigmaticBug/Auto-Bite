package com.bitecode.autobite.screens.shared.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bitecode.autobite.screens.shared.core.Trip

@Database(entities = [Trip::class], version = 1, exportSchema = true)
@TypeConverters(SharedTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tripsDao(): TripsDao
}