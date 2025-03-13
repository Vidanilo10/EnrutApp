package com.abc.enrut.enrut.domain.model


data class UserAuth(
    val AuthFlow: String = "USER_PASSWORD_AUTH",
    val ClientId: String = "2lr16op9ctch29caq1kdna24nt",
    val AuthParameters: AuthParameters = AuthParameters(
        USERNAME="andersong.9012@gmail.com",
        PASSWORD="And3rs0n##695401"
    )
)


data class AuthParameters(
    val USERNAME: String,
    val PASSWORD: String
)
