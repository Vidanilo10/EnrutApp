package com.abc.enrut.enrut.di

import android.app.Application
import android.content.Context
import com.abc.enrut.enrut.data.repository.DatastoreRepositoryImp
import com.abc.enrut.enrut.data.repository.LocationRepositoryImp
import com.abc.enrut.enrut.domain.repository.DatastoreRepository
import com.abc.enrut.enrut.domain.repository.LocationRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesDatastoreRepo(
        @ApplicationContext context: Context
    ):DatastoreRepository = DatastoreRepositoryImp(context)


    @Singleton
    @Provides
    fun providesLocationRepo(app: Application): FusedLocationProviderClient{
        return LocationServices.getFusedLocationProviderClient(app)
    }
}