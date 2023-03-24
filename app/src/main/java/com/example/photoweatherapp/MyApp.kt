package com.example.photoweatherapp

import android.app.Application
import com.example.photoweatherapp.util.initFresco
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initFresco(this)
    }
}