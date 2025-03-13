package com.abc.enrut.enrut.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abc.enrut.enrut.data.local.entity.TokenEntity

@Dao
interface TokenDao {
    @Query("SELECT * FROM token WHERE value LIKE '%' || :value || '%'")
    suspend fun getTokenByValue(value: String): MutableList<TokenEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTokenValue(tokenEntity: TokenEntity): Long
}