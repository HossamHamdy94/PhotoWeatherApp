package com.example.data.repository

import com.example.data.local.datasource.IWeatherLocalDatasource
import com.example.data.local.entities.LocalWeatherEntity
import com.example.data.remote.datasource.WeatherRemoteDatasource
import com.example.data.remote.dto.CurrentWeatherDTO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IMPWeatherRepository @Inject constructor(
    private val remoteDatasource: WeatherRemoteDatasource,
    private val localDatasource: IWeatherLocalDatasource)
    :WeatherRepository {
    override suspend fun addWeatherItem(item: LocalWeatherEntity) {
        localDatasource.addWeatherItem(item)
    }

    override suspend fun editWeatherItem(item: LocalWeatherEntity) {
        localDatasource.updateWeatherItem(item)
    }

    override suspend fun clearWeatherItem(item: LocalWeatherEntity) {
        localDatasource.deleteWeatherItem(item)
    }

    override suspend fun getWeatherItem(itemId: Int) :LocalWeatherEntity? {
        return localDatasource.getWeatherItem(itemId)
    }

    override suspend fun getWeatherItems(): Flow<List<LocalWeatherEntity>?> {
        return localDatasource.getWeatherItems()
    }

    override suspend fun getCurrentWeatherData(latLng:String): CurrentWeatherDTO? {
        return remoteDatasource.currentWeather(latLng)
    }
}