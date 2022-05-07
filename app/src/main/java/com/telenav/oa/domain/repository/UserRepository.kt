package com.telenav.oa.domain.repository

import com.telenav.oa.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    val user: User
    suspend fun isLogin(): Boolean
    suspend fun login(username: String, md5EncryptedPwd: String): Flow<User>
    suspend fun logout()
}