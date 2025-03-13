package com.abc.enrut.enrut.data.local.entity

import androidx.room.Entity
import androidx.room.ColumnInfo

@Entity(tableName = "token")
data class TokenEntity(
    @ColumnInfo(name="value") var value: String? = ""
)
