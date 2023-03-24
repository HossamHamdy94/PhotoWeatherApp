package com.example.data.local.datasource

import com.example.data.ICoroutineDispatchers
import com.example.data.local.dao.WeatherDao
import com.example.data.local.entities.LocalWeatherEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherLocalDatasource @Inject constructor(private val dao:WeatherDao,private val coroutineScopeDispatchers: ICoroutineDispatchers
    ) :IWeatherLocalDatasource {

    override suspend fun addWeatherItem(item: LocalWeatherEntity) {
        return withContext(coroutineScopeDispatchers.IO){
            dao.addWeatherItem(item)
        }
    }

    override suspend fun updateWeatherItem(item: LocalWeatherEntity) {
        return withContext(coroutineScopeDispatchers.IO){
            dao.updateWeatherItem(item)

        }
    }

    override suspend fun deleteWeatherItem(item: LocalWeatherEntity) {
        return withContext(coroutineScopeDispatchers.IO){
            dao.deleteWeatherItem(item)
        }
    }

    override suspend fun getWeatherItems(): Flow<List<LocalWeatherEntity>?> {
        return withContext(coroutineScopeDispatchers.IO){
            dao.getWeatherItems()
        }
    }

    override suspend fun getWeatherItem(itemId: Int): LocalWeatherEntity? {
        return withContext(coroutineScopeDispatchers.IO){
            dao.getWeatherItem(itemId)
        }
    }
}