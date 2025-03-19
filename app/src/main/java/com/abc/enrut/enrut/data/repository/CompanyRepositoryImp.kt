package com.abc.enrut.enrut.data.repository

import com.abc.enrut.enrut.domain.repository.CompanyRepository
import com.abc.enrut.enrut.core.Constants

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CompanyRepositoryImp {

    private val BASE_URL = Constants.hostname

    val api: CompanyRepository by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CompanyRepository::class.java)
    }



}