package com.example.data.local.dao

import androidx.room.*
import com.example.data.local.entities.LocalWeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWeatherItem(item: LocalWeatherEntity)

    @Update
    suspend fun updateWeatherItem(item: LocalWeatherEntity)

    @Delete
    suspend fun deleteWeatherItem(item: LocalWeatherEntity)

    @Query("Select * From WeatherItems Order BY id Desc")
    fun getWeatherItems(): Flow<List<LocalWeatherEntity>?>

    @Query("Select * From WeatherItems Where id = :itemId")
    suspend fun getWeatherItem(itemId: Int): LocalWeatherEntity?
}