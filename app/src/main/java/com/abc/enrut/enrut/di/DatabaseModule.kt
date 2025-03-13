package com.abc.enrut.enrut.di

import android.content.Context
import androidx.room.Room
import com.abc.enrut.enrut.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesRoomDataBase(@ApplicationContext appContext: Context): AppDatabase{
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java, "local-database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideTokenDao(db: AppDatabase) = db.tokenDao()

}