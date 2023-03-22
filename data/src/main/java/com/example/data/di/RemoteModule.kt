package com.example.data.di

import com.example.data.ICoroutineDispatchers

import com.example.data.remote.RemoteApiService
import com.example.data.remote.datasource.WeatherRemoteDatasource
import com.example.data.remote.datasource.IMPWeatherRemoteDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RemoteModule {

    @Singleton
    @Provides
    fun provideWeatherRemoteDataSource(servicesApi: RemoteApiService,coroutineDispatchers: ICoroutineDispatchers): WeatherRemoteDatasource {
        return IMPWeatherRemoteDatasource(servicesApi,coroutineDispatchers)
    }

}