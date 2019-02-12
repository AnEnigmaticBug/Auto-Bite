package com.bitecode.autobite

import android.app.Application
import com.bitecode.autobite.di.shared.AppComponent
import com.bitecode.autobite.di.shared.AppModule
import com.bitecode.autobite.di.shared.DaggerAppComponent
import com.jakewharton.threetenabp.AndroidThreeTen

class AutoBiteApp : Application() {

    companion object {

        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        AndroidThreeTen.init(this)
    }
}