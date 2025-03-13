package com.abc.enrut.enrut.di

import androidx.room.Insert
import com.abc.enrut.enrut.data.repository.LocalStorageRepositoryImp
import com.abc.enrut.enrut.domain.repository.LocalStorageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindLocalStorageRepository(localStorageRepositoryImp: LocalStorageRepositoryImp): LocalStorageRepository

}