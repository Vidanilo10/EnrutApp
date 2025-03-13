package com.abc.enrut.enrut.data.repository

import com.abc.enrut.enrut.data.local.dao.TokenDao
import com.abc.enrut.enrut.domain.model.TokenModel
import com.abc.enrut.enrut.domain.model.toTokenEntity
import com.abc.enrut.enrut.domain.repository.LocalStorageRepository
import javax.inject.Inject


class LocalStorageRepositoryImp @Inject constructor(private val tokenDao: TokenDao): LocalStorageRepository{
    override suspend fun saveTokenValue(tokenModel: TokenModel): Boolean {
        try {
            val result = tokenDao.insertTokenValue(tokenModel.toTokenEntity())
            return result.toInt() != -1
        }catch (e: Exception){
            throw e
        }
    }

    override suspend fun getTokenByValue(value: String): TokenModel {
        try {
            var tokenValue: String = ""
            tokenDao.getTokenByValue(value).map {
                tokenValue += it.value
            }
            return TokenModel(
                value = tokenValue
            )
        }catch (e: Exception){
            throw e
        }
    }
}
