package com.abc.enrut.domain.repository

import com.abc.enrut.domain.model.User
import retrofit2.http.POST

interface UserRepository {
    @POST("")
    suspend fun login(): User
}