package com.example.data.di

import android.app.Application
import androidx.room.Room
import com.example.data.Constns.DB_NAME
import com.example.data.local.MyLocalDB
import com.example.data.local.dao.WeatherDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DBModule {

    @Singleton
    @Provides
    fun provideWeatherDao(appDataBase: MyLocalDB): WeatherDao {
        return appDataBase.weatherDao()
    }

    @Singleton
    @Provides
    fun provideAppDataBase(application: Application): MyLocalDB {
        return Room.databaseBuilder(
            application,
            MyLocalDB::class.java,
            DB_NAME
        ).build()
    }

}