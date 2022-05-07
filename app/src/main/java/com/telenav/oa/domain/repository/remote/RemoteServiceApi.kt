package com.telenav.oa.domain.repository.remote

import com.telenav.oa.domain.repository.remote.dto.LoginRequest
import com.telenav.oa.domain.repository.remote.dto.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RemoteServiceApi {
    companion object {
        const val BASE_URL = "http://kaoqin.telenav.com:8100/"
    }

    @POST("login.whtml")
    fun login(@Body loginRequest: LoginRequest): String
}