package com.abc.enrut.domain.repository

import com.abc.enrut.domain.model.Position
import retrofit2.http.POST


interface PositionRepository {
    @POST("/companies/AYACUCHO-2024/vehicles/AYACUCHO-02/positions")
    suspend fun registerPosition(): Position
}