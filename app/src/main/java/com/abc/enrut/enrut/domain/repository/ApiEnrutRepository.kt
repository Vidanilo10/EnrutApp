package com.abc.enrut.enrut.domain.repository

import com.abc.enrut.enrut.domain.model.AuthModel
import com.abc.enrut.enrut.domain.model.UserAuth
import com.abc.enrut.enrut.core.Constants
import com.abc.enrut.enrut.domain.model.Company
import com.abc.enrut.enrut.domain.model.Position

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiEnrutRepository {
    @POST(Constants.loginEnpoint)
    suspend fun login(@Body auth: UserAuth): AuthModel

    @POST(Constants.positionsEndpoint)
    suspend fun registerPosition(@Header(Constants.authorizationString) authorization: String): Position

    @GET(Constants.companiesEndpoint)
    suspend fun queryCompanies(@Header(Constants.authorizationString) authorization: String): MutableList<Company>

}