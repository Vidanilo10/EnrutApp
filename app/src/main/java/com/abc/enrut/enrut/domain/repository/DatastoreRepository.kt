package com.abc.enrut.enrut.domain.repository

interface DatastoreRepository {
    suspend fun saveToken(key: String, value: String)

    suspend fun getToken(key: String): String?

}