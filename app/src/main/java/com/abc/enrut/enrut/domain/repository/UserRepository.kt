package com.abc.enrut.enrut.domain.repository

import com.abc.enrut.enrut.domain.model.User
import retrofit2.http.POST

interface UserRepository {
    @POST("")
    suspend fun login(): User
}