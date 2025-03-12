package com.abc.enrut.enrut.domain.repository


import com.abc.enrut.enrut.domain.model.Company
import retrofit2.http.GET

interface CompanyRepository {
    @GET("/companies")
    suspend fun queryCompanies(): Company
}