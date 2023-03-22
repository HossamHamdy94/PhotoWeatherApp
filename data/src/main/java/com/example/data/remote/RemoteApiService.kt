package com.example.data.remote

import com.example.data.remote.dto.CurrentWeatherDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteApiService {
    @GET("current.json")
    suspend fun currentWeather(
        @Query("q") latLng:String
    ): Response<CurrentWeatherDTO>
}