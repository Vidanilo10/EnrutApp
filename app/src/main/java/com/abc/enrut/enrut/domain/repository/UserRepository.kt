package com.abc.enrut.enrut.domain.repository

import com.abc.enrut.enrut.domain.model.AuthModel
import com.abc.enrut.enrut.domain.model.AuthenticationResult
import com.abc.enrut.enrut.domain.model.UserAuth
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserRepository {
    @Headers("X-Amz-Target: AWSCognitoIdentityProviderService.InitiateAuth", "Content-Type: application/x-amz-json-1.1")
    @POST("/")
    suspend fun login(@Body auth: UserAuth): AuthModel
}