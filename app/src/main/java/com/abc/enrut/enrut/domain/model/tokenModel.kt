package com.abc.enrut.enrut.domain.model

import com.abc.enrut.enrut.data.local.entity.TokenEntity

data class TokenModel(
    var value: String
)

fun TokenModel.toTokenEntity(): TokenEntity{
    return TokenEntity(
        value = this.value
    )
}
