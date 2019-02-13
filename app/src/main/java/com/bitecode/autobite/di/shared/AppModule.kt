package com.bitecode.autobite.di.shared

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.bitecode.autobite.screens.shared.data.repo.TripRepository
import com.bitecode.autobite.screens.shared.data.repo.TripRepositoryImpl
import com.bitecode.autobite.screens.shared.data.repo.UserRepository
import com.bitecode.autobite.screens.shared.data.repo.UserRepositoryImpl
import com.bitecode.autobite.screens.shared.data.room.AppDatabase
import com.bitecode.autobite.screens.shared.data.room.TripsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Singleton
    @Provides
    fun providesUserRepository(sharedPreferences: SharedPreferences): UserRepository =
        UserRepositoryImpl(sharedPreferences)

    @Singleton
    @Provides
    fun providesTripRepository(tripsDao: TripsDao): TripRepository = TripRepositoryImpl(tripsDao)

    @Singleton
    @Provides
    fun providesTripsDao(appDatabase: AppDatabase): TripsDao = appDatabase.tripsDao()

    @Singleton
    @Provides
    fun providesSharedPreferences(application: Application): SharedPreferences =
        application.getSharedPreferences("autobite.sp", Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun providesAppDatabase(application: Application): AppDatabase = Room
        .databaseBuilder(application, AppDatabase::class.java, "autobite.db")
        .build()

    @Singleton
    @Provides
    fun providesApplication(): Application = application
}