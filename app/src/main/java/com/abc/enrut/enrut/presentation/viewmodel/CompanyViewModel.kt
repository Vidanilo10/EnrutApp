package com.abc.enrut.enrut.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abc.enrut.enrut.core.Constants
import com.abc.enrut.enrut.data.repository.ApiEnrutRepositoryImp
import com.abc.enrut.enrut.domain.repository.DatastoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@HiltViewModel
class CompanyViewModel @Inject constructor(
    private val datastoreRepository: DatastoreRepository
): ViewModel() {

    val company = mutableStateOf("Fetching companies...")

    init {
        fetchCompanies()
    }

    private fun getToken() = runBlocking {
        datastoreRepository.getToken(key=Constants.tokenString)
    }

    fun fetchCompanies() {
        viewModelScope.launch {
            try {
                val response = ApiEnrutRepositoryImp.api.queryCompanies(authorization = Constants.bearerString.plus(getToken()))
                println(response)
            } catch (e: Exception) {
                company.value = "Error: ${e.message}"
            }
        }
    }


}