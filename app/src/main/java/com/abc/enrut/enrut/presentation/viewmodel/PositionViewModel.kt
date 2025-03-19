package com.abc.enrut.enrut.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.abc.enrut.enrut.core.Constants
import com.abc.enrut.enrut.data.repository.ApiEnrutRepositoryImp
import com.abc.enrut.enrut.domain.model.Location
import com.abc.enrut.enrut.domain.repository.DatastoreRepository
import com.abc.enrut.enrut.domain.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@HiltViewModel
class PositionViewModel @Inject constructor(
    private val datastoreRepository: DatastoreRepository,
    private val locationRepository: LocationRepository
): ViewModel(){

    val position = mutableStateOf("Creating position...")

    val currentLocation: MutableLiveData<Location?> = MutableLiveData()

    init {
        fetchPosition()
    }

    private fun getToken() = runBlocking {
        datastoreRepository.getToken(key= Constants.tokenString)
    }


    fun getLatitude(): Double? {
        return currentLocation.value?.latitude
    }

    fun getLongitude(): Double? {
        return currentLocation.value?.longitude
    }


    fun fetchPosition() {
        viewModelScope.launch {
            try {
                locationRepository.getCurrentLocation { location ->
                    currentLocation.postValue(location)
                }
                val r = getLongitude()
                print(r)
                val response = ApiEnrutRepositoryImp.api.registerPosition(authorization = Constants.bearerString.plus(getToken()))
                print(response)
                position.value = response.tripId
            } catch (e: Exception) {
                position.value = "Error: ${e.message}"
            }
        }
    }



}






