package com.abc.enrut.enrut.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.abc.enrut.enrut.core.Constants
import com.abc.enrut.enrut.data.repository.ApiEnrutRepositoryImp
import com.abc.enrut.enrut.domain.model.Location
import com.abc.enrut.enrut.domain.model.Position
import com.abc.enrut.enrut.domain.model.PositionsBody
import com.abc.enrut.enrut.domain.repository.DatastoreRepository
import com.abc.enrut.enrut.domain.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import android.location.Location as AndroidLocation


@Suppress("UNREACHABLE_CODE")
@HiltViewModel
class PositionViewModel @Inject constructor(
    private val datastoreRepository: DatastoreRepository,
    private val locationRepository: LocationRepository
): ViewModel(){


    val position = mutableStateOf("Position ...")

    private val _currentLocation = MutableLiveData<Location?>()
    val currentLocation: LiveData<Location?> get() = _currentLocation


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        getCurrentLocation()
    }

    private fun getToken() = runBlocking {
        datastoreRepository.getToken(key= Constants.tokenString)
    }


    suspend fun writePositions(positions: PositionsBody) {
        val token = Constants.bearerString.plus(getToken())

        try {
            val response = ApiEnrutRepositoryImp.api.registerPosition(
                authorization = token,
                position = positions
            )
            println(response)
        } catch (e: Exception) {
           val error = "Error: ${e.message}"
            print(error)
        }

    }

    fun getPositionsData(location: AndroidLocation): PositionsBody {

        val tim = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS").withZone(ZoneOffset.UTC).format(Instant.now())

        if (tim is String){
            print("foo")
        }

        val position = mapOf(
            "timestamp" to DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS").withZone(ZoneOffset.UTC).format(Instant.now()),
            "latitude" to location.latitude,
            "longitude" to location.longitude,
            "speed" to location.speed.toDouble(),
            "altitude" to location.altitude,
            "accuracy" to location.accuracy.toDouble(),
            "tripId" to "trip789-labios"
        )


        return PositionsBody(
            positions = arrayOf(position)
        )

    }


    fun getCurrentLocation() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val location = locationRepository.getCurrentLocation()

                val data = location?.let { getPositionsData(location= it) }

                if (data != null) {
                    writePositions(
                        positions = data
                    )
                }


            } catch (e: Exception) {
                // Handle exceptions if necessary
                _currentLocation.value = null
            } finally {
                _isLoading.value = false

            }
        }
    }

}






