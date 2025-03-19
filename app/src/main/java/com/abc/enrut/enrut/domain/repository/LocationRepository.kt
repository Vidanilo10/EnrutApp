package com.abc.enrut.enrut.domain.repository

import com.abc.enrut.enrut.domain.model.Location
import com.abc.enrut.enrut.presentation.viewmodel.PositionViewModel
import com.google.android.gms.location.LocationResult

interface LocationRepository {

    suspend fun getCurrentLocation(callback: (Location?) -> Unit)

}