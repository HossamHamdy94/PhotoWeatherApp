package com.example.data.remote.datasource

import com.example.data.ICoroutineDispatchers
import com.example.data.remote.NetworkUtil
import com.example.data.remote.RemoteApiService
import com.example.data.remote.dto.CurrentWeatherDTO
import kotlinx.coroutines.withContext
import javax.inject.Inject

class IMPWeatherRemoteDatasource @Inject constructor (
    private val api:RemoteApiService,
    private val coroutineScopeDispatchers: ICoroutineDispatchers
    ):WeatherRemoteDatasource {
    override suspend fun currentWeather(latLng: String): CurrentWeatherDTO? {
        return withContext(coroutineScopeDispatchers.IO){
            NetworkUtil.processAPICall { api.currentWeather(latLng) }
        }
    }
}