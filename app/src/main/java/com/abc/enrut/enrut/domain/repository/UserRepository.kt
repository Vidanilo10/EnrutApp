package com.abc.enrut.enrut.domain.repository

import com.abc.enrut.enrut.domain.model.AuthModel
import com.abc.enrut.enrut.domain.model.AuthenticationResult
import com.abc.enrut.enrut.domain.model.UserAuth
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserRepository {
    //@Headers("Content-Type: application/json")
    @POST("/login")
    suspend fun login(@Body auth: UserAuth): AuthModel
}