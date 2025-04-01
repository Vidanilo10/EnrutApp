package com.abc.enrut.enrut.domain.model

data class Position(
    val timestamp: String?,
    val latitude: Double?,
    val longitude: Double?,
    val speed: String?,
    val altitude: Double?,
    val accuracy: Double?,
    val tripId: String?
)

data class PositionsBody(
    val positions: Array<Any>
)

data class PositionsResponse(
    val pendingAlerts: String
)



