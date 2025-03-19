package com.abc.enrut.enrut.domain.model

import com.abc.enrut.enrut.core.Constants


data class UserAuth(
    val username: String = Constants.username,
    val password: String = Constants.password
)
