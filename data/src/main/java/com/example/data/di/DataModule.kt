package com.example.data.di

import com.example.data.AppCoroutineDispatchers
import com.example.data.ICoroutineDispatchers
import com.example.data.local.datasource.IWeatherLocalDatasource
import com.example.data.remote.datasource.WeatherRemoteDatasource
import com.example.data.repository.IMPWeatherRepository
import com.example.data.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Singleton
    @Provides
    fun providesCoroutineDispatcher():ICoroutineDispatchers{
        return AppCoroutineDispatchers()
    }

    @Singleton
    @Provides
    fun providesWeatherRepository(remoteDatasource: WeatherRemoteDatasource, localWeatherLocalDatasource: IWeatherLocalDatasource): WeatherRepository {
        return IMPWeatherRepository(remoteDatasource,localWeatherLocalDatasource)
    }
}