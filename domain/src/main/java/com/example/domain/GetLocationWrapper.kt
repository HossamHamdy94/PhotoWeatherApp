package com.example.domain

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import kotlinx.coroutines.ExperimentalCoroutinesApi

interface GetLocationWrapper {
    fun getLocation(): FusedLocationProviderClient
}

@ExperimentalCoroutinesApi
class GetLocationWrapperImpl(
    private val context: Context
) : GetLocationWrapper {
    override fun getLocation(): FusedLocationProviderClient {
        return     LocationServices.getFusedLocationProviderClient(context)

    }


}

@ExperimentalCoroutinesApi
class UniqueIDGeneratorUseCase(
    private val getLocationWrapper: GetLocationWrapper
) {

    fun getLocation() = getLocationWrapper.getLocation()

}
