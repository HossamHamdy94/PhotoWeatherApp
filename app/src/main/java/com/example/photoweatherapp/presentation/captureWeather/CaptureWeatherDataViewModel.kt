package com.example.photoweatherapp.presentation.captureWeather

import android.location.Location
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.resource.Resource
import com.example.domain.model.WeatherItem
import com.example.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CaptureWeatherDataViewModel @Inject constructor(
    private val state: SavedStateHandle,
    private val validateAddingWeatherItemUseCase: ValidateAddingWeatherItemUseCase,
    private val saveWeatherItemUseCase: SaveWeatherItemUseCase,
    private val fetchCurrentLocationUseCase: FetchCurrentLocationUseCase,
    private val getCurrentWeatherDataUseCase: GetCurrentWeatherDataUseCase
):ViewModel() {

    private val _currentWeatherDataStateFlow = MutableStateFlow<Resource<WeatherItem?>>(Resource.Initial())
    val currentWeatherDataStateFlow: StateFlow<Resource<WeatherItem?>> = _currentWeatherDataStateFlow

    private val _weatherInputValidations = MutableStateFlow<WeatherInputValidations?>(null)
    val weatherInputValidations: StateFlow<WeatherInputValidations?> = _weatherInputValidations

    private val _finish = MutableStateFlow<Boolean>(false)
    val finish: StateFlow<Boolean> = _finish

    private val _currentLocation = MutableStateFlow<Location?>(null)
    val currentLocation: StateFlow<Location?> = _currentLocation

    fun fetchCurrentLocation(){
        viewModelScope.launch {
            fetchCurrentLocationUseCase().distinctUntilChanged().collect{location->
                location?.let {
                    _currentLocation.value=location
                    loadCurrentWeatherData("${location.latitude},${location.latitude}")
                }
            }
        }
    }

    private fun loadCurrentWeatherData(latLag:String){
        viewModelScope.launch {
            _currentWeatherDataStateFlow.value=Resource.Loading()
            try {
                val weatherData=getCurrentWeatherDataUseCase(latLag)
                _currentWeatherDataStateFlow.value=Resource.SUCCESS(weatherData)
            }catch (t:Throwable){
                _currentWeatherDataStateFlow.value=Resource.ERROR(t)
            }

        }
    }

    fun onSaveClick(degree:String?,city:String?,condition:String?){

        val validationError=validateAddingWeatherItemUseCase(degree,city, condition)

        validationError?.let {
            _weatherInputValidations.value

        }?: run {
            saveWeatherData(degree!!.toDouble(),city!!,condition!!)

        }
    }

    private fun saveWeatherData(degree:Double,city:String,condition:String){
        viewModelScope.launch {
            val photoPath =state.get<String>("capturePhotoPath")
            Timber.tag("hossam").d(photoPath)
            saveWeatherItemUseCase(WeatherItem(temp = degree, cityName = city, description = condition, photoPath = photoPath))
            _finish.value=true
        }
    }

}