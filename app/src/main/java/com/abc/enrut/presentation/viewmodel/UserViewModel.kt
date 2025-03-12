package com.abc.enrut.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abc.enrut.data.repository.UserRepositoryImp
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    val username = mutableStateOf("Fetching position...")

    init {
        login()
    }

    fun login() {
        viewModelScope.launch {
            try {
                val response = UserRepositoryImp.api.login()
                username.value = response.username
            } catch (e: Exception) {
                username.value = "Error: ${e.message}"
            }
        }
    }


}