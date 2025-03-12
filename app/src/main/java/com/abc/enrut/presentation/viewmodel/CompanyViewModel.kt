package com.abc.enrut.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abc.enrut.data.repository.CompanyRepositoryImp
import kotlinx.coroutines.launch

class CompanyViewModel: ViewModel() {

    val company = mutableStateOf("Fetching companies...")

    init {
        fetchCompanies()
    }

    fun fetchCompanies() {
        viewModelScope.launch {
            try {
                val response = CompanyRepositoryImp.api.queryCompanies()
                company.value = response.id
            } catch (e: Exception) {
                company.value = "Error: ${e.message}"
            }
        }
    }


}