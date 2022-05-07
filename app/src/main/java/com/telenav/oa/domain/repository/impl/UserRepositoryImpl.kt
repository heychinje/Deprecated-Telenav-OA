package com.telenav.oa.domain.repository.impl

import com.telenav.oa.domain.model.User
import com.telenav.oa.domain.repository.UserRepository
import com.telenav.oa.domain.repository.remote.RemoteServiceApi
import com.telenav.oa.domain.repository.remote.dto.LoginEntity
import com.telenav.oa.domain.repository.remote.dto.LoginRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl(
    private val remoteServiceApi: RemoteServiceApi
) : UserRepository {
    override val user: User
        get() = TODO("Not yet implemented")

    override suspend fun isLogin(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun login(username: String, md5EncryptedPwd: String): Flow<User> {
        val loginResponse = remoteServiceApi.login(
            LoginRequest(loginEntity = LoginEntity(username, md5EncryptedPwd))
        )
        return flow { }
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }
}