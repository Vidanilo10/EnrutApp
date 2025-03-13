package com.abc.enrut.enrut.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abc.enrut.enrut.data.local.dao.TokenDao
import com.abc.enrut.enrut.data.local.entity.TokenEntity

@Database(entities = [TokenEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun tokenDao(): TokenDao

}