package com.abc.enrut.enrut.domain.repository

import com.abc.enrut.enrut.domain.model.TokenModel

interface LocalStorageRepository {

    suspend fun saveTokenValue(tokenModel: TokenModel): Boolean

    suspend fun getTokenByValue(): TokenModel

}