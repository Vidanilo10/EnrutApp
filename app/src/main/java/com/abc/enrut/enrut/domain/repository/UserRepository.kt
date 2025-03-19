package com.abc.enrut.enrut.domain.repository

import com.abc.enrut.enrut.domain.model.AuthModel
import com.abc.enrut.enrut.domain.model.UserAuth
import com.abc.enrut.enrut.core.Constants

import retrofit2.http.Body
import retrofit2.http.POST

interface UserRepository {
    @POST(Constants.loginEnpoint)
    suspend fun login(@Body auth: UserAuth): AuthModel
}