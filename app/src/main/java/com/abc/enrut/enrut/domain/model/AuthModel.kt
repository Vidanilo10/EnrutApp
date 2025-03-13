package com.abc.enrut.enrut.domain.model

data class AuthModel(
    val AuthenticationResult: AuthenticationResult
)


data class AuthenticationResult(
    val AccessToken: String,
    val ExpiresIn: Int,
    val IdToken: String,
    val RefreshToken: String,
    val TokenType: String
)
