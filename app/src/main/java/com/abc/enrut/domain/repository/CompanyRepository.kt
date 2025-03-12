package com.abc.enrut.domain.repository


import com.abc.enrut.domain.model.Company
import retrofit2.http.GET

interface CompanyRepository {
    @GET("/companies")
    suspend fun queryCompanies(): Company
}