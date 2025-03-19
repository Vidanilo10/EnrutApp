package com.abc.enrut.enrut.data.repository

import com.abc.enrut.enrut.domain.repository.UserRepository
import com.abc.enrut.enrut.core.Constants

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserRepositoryImp {
    private val BASE_URL = Constants.hostname

    val api: UserRepository by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserRepository::class.java)
    }
}