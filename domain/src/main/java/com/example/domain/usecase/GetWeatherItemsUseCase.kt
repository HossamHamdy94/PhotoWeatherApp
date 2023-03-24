package com.example.domain.usecase

import com.example.data.repository.WeatherRepository
import com.example.domain.mapper.LocalMapper
import com.example.domain.model.WeatherItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetWeatherItemsUseCase @Inject constructor (private val repository: WeatherRepository) {
    suspend operator fun invoke(): Flow<List<WeatherItem?>?> {
        return repository.getWeatherItems().map { listItem ->
            listItem?.map { LocalMapper.mapToDomain(it) }
        }
    }
}