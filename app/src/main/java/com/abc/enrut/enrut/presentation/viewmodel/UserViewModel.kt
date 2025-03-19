package com.abc.enrut.enrut.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abc.enrut.enrut.core.Constants
import com.abc.enrut.enrut.data.repository.ApiEnrutRepositoryImp
import com.abc.enrut.enrut.domain.model.UserAuth
import com.abc.enrut.enrut.domain.repository.DatastoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val datastoreRepository: DatastoreRepository
): ViewModel() {

    val username = mutableStateOf("Login ...")

    init {
        login()
    }

    private fun storeToken(value: String) = runBlocking {
        datastoreRepository.saveToken(
            key = Constants.tokenString,
            value = value
        )
    }


    private fun getToken() = runBlocking {
        datastoreRepository.getToken(key=Constants.tokenString)
    }



    fun login() {
        viewModelScope.launch {
            val userAuthInst = UserAuth()

            try {
                val response = ApiEnrutRepositoryImp.api.login(auth=userAuthInst)
                println(response)

                storeToken(value = response.idToken)

                println(1)

                val getToken = getToken()

                print(getToken)

            } catch (e: Exception) {
                throw e
            }
        }
    }


}