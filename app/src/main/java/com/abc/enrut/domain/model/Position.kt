package com.abc.enrut.domain.model

data class Position(
    val timestamp: String,
    val latitude: Double,
    val longitude: Double,
    val speed: Double,
    val altitude: Double,
    val accuracy: Int,
    val tripId: String
)
