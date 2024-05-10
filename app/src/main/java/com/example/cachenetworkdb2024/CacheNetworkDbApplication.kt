package com.example.cachenetworkdb2024

import android.app.Application
import timber.log.Timber

class CacheNetworkDbApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}