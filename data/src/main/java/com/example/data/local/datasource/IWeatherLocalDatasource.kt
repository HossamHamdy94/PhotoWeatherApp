package com.example.data.local.datasource

import com.example.data.local.entities.LocalWeatherEntity
import kotlinx.coroutines.flow.Flow


interface IWeatherLocalDatasource {
    suspend fun addWeatherItem(item: LocalWeatherEntity)
    suspend fun updateWeatherItem(item: LocalWeatherEntity)
    suspend fun deleteWeatherItem(item: LocalWeatherEntity)
    suspend fun getWeatherItems(): Flow<List<LocalWeatherEntity>?>
    suspend fun getWeatherItem(itemId: Int): LocalWeatherEntity?
}