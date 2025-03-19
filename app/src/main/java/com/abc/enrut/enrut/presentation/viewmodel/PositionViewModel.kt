package com.abc.enrut.enrut.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.abc.enrut.enrut.core.Constants
import com.abc.enrut.enrut.data.repository.ApiEnrutRepositoryImp
import com.abc.enrut.enrut.domain.repository.DatastoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@HiltViewModel
class PositionViewModel @Inject constructor(
    private val datastoreRepository: DatastoreRepository
): ViewModel(){
    val position = mutableStateOf("Fetching positions...")

    init {
        fetchPosition()
    }

    private fun getToken() = runBlocking {
        datastoreRepository.getToken(key= Constants.tokenString)
    }

    fun fetchPosition() {
        viewModelScope.launch {
            try {
                val response = ApiEnrutRepositoryImp.api.registerPosition(authorization = Constants.bearerString.plus(getToken()))

                position.value = response.tripId
            } catch (e: Exception) {
                position.value = "Error: ${e.message}"
            }
        }
    }



}






