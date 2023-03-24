package com.example.domain.usecase

import com.example.data.repository.WeatherRepository
import com.example.domain.mapper.RemoteMapper
import com.example.domain.model.WeatherItem
import javax.inject.Inject

class GetCurrentWeatherDataUseCase @Inject constructor (private val repository: WeatherRepository) {
    suspend operator fun invoke(latLng:String ): WeatherItem? {
        return RemoteMapper.mapToDomain(repository.getCurrentWeatherData(latLng))
    }
}