package com.abc.enrut.enrut.domain.repository

import android.location.Location

interface LocationRepository {
    suspend fun getCurrentLocation(): Location?

}