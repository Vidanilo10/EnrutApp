package com.abc.enrut.enrut.presentation

import android.content.Context
import com.abc.enrut.enrut.data.repository.DatastoreRepositoryImp
import com.abc.enrut.enrut.data.repository.LocationRepositoryImp
import com.abc.enrut.enrut.domain.repository.DatastoreRepository
import com.abc.enrut.enrut.domain.repository.LocationRepository
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
    fun providesLocationRepo(
        @ApplicationContext context: Context
    ):LocationRepository = LocationRepositoryImp(context)

}