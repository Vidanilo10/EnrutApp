package com.abc.enrut.enrut.data.remote.interceptors

import com.abc.enrut.enrut.core.Constants
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val unauthenticatedPaths = listOf(Constants.loginEnpoint)

        val shouldSkipAuth = unauthenticatedPaths.any { path ->
            originalRequest.url().encodedPath().startsWith(path)
        }

        if (shouldSkipAuth) {
            return chain.proceed(originalRequest)
        }

        /*
        fun getToken() = runBlocking {
            datastoreRepository.getToken(key= Constants.tokenString)
        }
        */


        val token = ""

        val requestBuilder = originalRequest.newBuilder()

        if (token.isNotEmpty()) {
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        val request = requestBuilder.build()

        return chain.proceed(request)
    }



}