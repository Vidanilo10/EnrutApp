package com.plcoding.weatherapp.di

import com.abc.enrut.enrut.data.repository.LocationRepositoryImp
import com.abc.enrut.enrut.domain.repository.LocationRepository


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {

    @Binds
    @Singleton
    abstract fun bindLocationTracker(defaultLocationTracker: LocationRepositoryImp): LocationRepository
}