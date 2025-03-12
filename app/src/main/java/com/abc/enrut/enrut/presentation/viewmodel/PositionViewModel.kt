package com.abc.enrut.enrut.presentation.viewmodel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.abc.enrut.enrut.data.repository.PositionRepositoryImp


class PositionViewModel : ViewModel(){
    val position = mutableStateOf("Fetching position...")

    init {
        fetchPosition()
    }

    fun fetchPosition() {
        viewModelScope.launch {
            try {
                val response = PositionRepositoryImp.api.registerPosition()

                position.value = response.tripId
            } catch (e: Exception) {
                position.value = "Error: ${e.message}"
            }
        }
    }



}






