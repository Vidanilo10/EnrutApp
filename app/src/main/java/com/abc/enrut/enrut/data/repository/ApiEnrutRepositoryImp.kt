package com.abc.enrut.enrut.data.repository

import com.abc.enrut.enrut.domain.repository.ApiEnrutRepository
import com.abc.enrut.enrut.core.Constants

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiEnrutRepositoryImp {
    private val BASE_URL = Constants.hostname

    val api: ApiEnrutRepository by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiEnrutRepository::class.java)
    }
}