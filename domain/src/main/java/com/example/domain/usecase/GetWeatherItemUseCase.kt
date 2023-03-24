package com.example.domain.usecase

import com.example.data.local.entities.LocalWeatherEntity
import com.example.data.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherItemUseCase @Inject constructor (private val repository: WeatherRepository) {
    suspend operator fun invoke(itemId: Int): LocalWeatherEntity? {
        return repository.getWeatherItem(itemId)
    }
}