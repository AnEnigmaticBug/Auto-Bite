package com.bitecode.autobite.screens

import android.app.Application
import com.bitecode.rickshawapp.di.shared.AppComponent
import com.bitecode.rickshawapp.di.shared.AppModule
import com.bitecode.rickshawapp.di.shared.DaggerAppComponent

class AutoBiteApp : Application() {

    companion object {

        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}