package com.abc.enrut.enrut.domain.model

data class AuthModel(
    val idToken: String,
    val accessToken: String,
    val refreshToken: String
)
