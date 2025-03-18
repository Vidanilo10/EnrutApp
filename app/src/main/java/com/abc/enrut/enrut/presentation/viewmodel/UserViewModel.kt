package com.abc.enrut.enrut.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abc.enrut.enrut.data.repository.UserRepositoryImp
import com.abc.enrut.enrut.domain.model.TokenModel
import com.abc.enrut.enrut.domain.model.UserAuth
import kotlinx.coroutines.launch



class UserViewModel: ViewModel() {

    val username = mutableStateOf("Login ...")

    init {
        login()
    }

    fun login() {
        viewModelScope.launch {
            val userAuthInst = UserAuth()

            try {
                val response = UserRepositoryImp.api.login(auth=userAuthInst)
                println(response)

                val tokenModel = TokenModel(
                    value = response.idToken
                )

                println(tokenModel)
            } catch (e: Exception) {
                throw e
            }
        }
    }


}