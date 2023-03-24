package com.example.domain.mapper

import com.example.data.local.entities.LocalWeatherEntity
import com.example.data.remote.dto.CurrentWeatherDTO
import com.example.domain.model.WeatherItem
import java.security.SecureRandom


object RemoteMapper:MyMapper<CurrentWeatherDTO,WeatherItem>{
    override fun mapToDomain(item: CurrentWeatherDTO?): WeatherItem? {
        return if (item==null) null else WeatherItem(
            id = SecureRandom().nextLong(),
            temp = item.current?.temp_c,
            description = item.current?.condition?.text,
            iconUrl = item.current?.condition?.icon,
            cityName = item.location?.name,
            photoPath = null
        )
    }

    override fun mapFromDomain(item: WeatherItem?): CurrentWeatherDTO? {
        //No thing for now
        return null
    }

}

object LocalMapper:MyMapper<LocalWeatherEntity,WeatherItem>{
    override fun mapToDomain(item: LocalWeatherEntity?): WeatherItem? {
        return if (item==null) null else WeatherItem(
            id = item.id,
            temp = item.temp,
            description = item.description,
            iconUrl = item.iconUrl,
            cityName = item.cityName,
            photoPath = item.photoPath
        )
    }

    override fun mapFromDomain(item: WeatherItem?): LocalWeatherEntity? {
        return if (item==null) null else
            LocalWeatherEntity(
            id = item.id,
            temp = item.temp,
            description = item.description,
            iconUrl = item.iconUrl,
            cityName = item.cityName,
            photoPath = item.photoPath
        )
    }

}