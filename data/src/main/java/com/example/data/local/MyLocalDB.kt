package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.Constns.DB_VERSION
import com.example.data.local.dao.WeatherDao
import com.example.data.local.entities.LocalWeatherEntity


@Database(entities = [LocalWeatherEntity::class], version = DB_VERSION, exportSchema = false)
abstract class MyLocalDB : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao
}