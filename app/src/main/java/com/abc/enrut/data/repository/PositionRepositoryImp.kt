package com.abc.enrut.data.repository
import com.abc.enrut.domain.repository.PositionRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object PositionRepositoryImp {
    private val BASE_URL = "https://skrfbs1bok.execute-api.us-east-2.amazonaws.com/dev"

    val api: PositionRepository by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PositionRepository::class.java)
    }

}