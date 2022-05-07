package com.telenav.oa.domain.repository.remote.dto

import com.google.gson.annotations.SerializedName


data class LoginResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Any,
    @SerializedName("jsessionId")
    val jsessionId: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("openid")
    val openid: Any,
    @SerializedName("result")
    val result: Any,
    @SerializedName("success")
    val success: Boolean
)