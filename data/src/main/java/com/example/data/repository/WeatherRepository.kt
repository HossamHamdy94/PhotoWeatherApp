package com.example.data.repository

import com.example.data.local.entities.LocalWeatherEntity
import com.example.data.remote.dto.CurrentWeatherDTO
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun addWeatherItem(item: LocalWeatherEntity)
    suspend fun editWeatherItem(item:LocalWeatherEntity)
    suspend fun clearWeatherItem(item:LocalWeatherEntity)
    suspend fun getWeatherItem(itemId:Int):LocalWeatherEntity?
    suspend fun getWeatherItems(): Flow<List<LocalWeatherEntity>?>
    suspend fun getCurrentWeatherData(latLng:String): CurrentWeatherDTO?
}