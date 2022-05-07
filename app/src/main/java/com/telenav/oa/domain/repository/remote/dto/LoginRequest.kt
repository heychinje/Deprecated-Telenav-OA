package com.telenav.oa.domain.repository.remote.dto

import com.google.gson.annotations.SerializedName


data class LoginRequest(
    @SerializedName("user")
    val loginEntity: LoginEntity,
    @SerializedName("loginURL")
    val loginURL: String = "http://kaoqin.telenav.com:8100/login.html"
)

data class LoginEntity(
    @SerializedName("userName")
    val userName: String,
    @SerializedName("password")
    val password: String
)