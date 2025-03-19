package com.abc.enrut.enrut.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abc.enrut.enrut.data.repository.ApiEnrutRepositoryImp
import kotlinx.coroutines.launch

class CompanyViewModel: ViewModel() {

    val company = mutableStateOf("Fetching companies...")

    init {
        fetchCompanies()
    }

    fun fetchCompanies() {
        viewModelScope.launch {
            try {
                val response = ApiEnrutRepositoryImp.api.queryCompanies()
                println(response)
            } catch (e: Exception) {
                company.value = "Error: ${e.message}"
            }
        }
    }


}