package com.abc.enrut.enrut.data.repository

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.abc.enrut.enrut.domain.model.Location
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult

import com.abc.enrut.enrut.domain.repository.LocationRepository
import com.abc.enrut.enrut.presentation.viewmodel.PositionViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import javax.inject.Inject


class LocationRepositoryImp @Inject constructor(
    private val context: Context
): LocationRepository{

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @SuppressLint("MissingPermission")
    override suspend fun getCurrentLocation(callback: (Location?) -> Unit) {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: android.location.Location? ->
                // Convert Android's Location to the domain model
                val domainLocation = location?.let {
                    Location(it.latitude, it.longitude)
                }
                // Call the callback with the result
                callback(domainLocation)
            }
    }

}