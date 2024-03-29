package com.example.domain.usecase

import com.example.data.repository.WeatherRepository
import com.example.domain.mapper.LocalMapper
import com.example.domain.model.WeatherItem
import javax.inject.Inject

class UpdateWeatherItemUseCase @Inject constructor(private val repository: WeatherRepository) {
    suspend operator fun invoke(item: WeatherItem){
        LocalMapper.mapFromDomain(item)?.let {
            repository.editWeatherItem(it)
        }
    }
}