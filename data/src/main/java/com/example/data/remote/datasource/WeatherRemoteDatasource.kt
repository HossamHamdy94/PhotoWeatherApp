package com.example.data.remote.datasource

import com.example.data.remote.dto.CurrentWeatherDTO

interface WeatherRemoteDatasource {
    suspend fun currentWeather(latLng:String): CurrentWeatherDTO?
}