package com.telenav.oa.domain.usecase

import com.telenav.oa.di.WorkDispatcher
import com.telenav.oa.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val md5UseCase: Md5UseCase,
    private val userRepository: UserRepository,
    @WorkDispatcher private val workDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(username: String, password: String) {
        withContext(workDispatcher) {
            val md5EncryptedPwd = md5UseCase(password.toByteArray(Charsets.UTF_8))
            val res = userRepository.login(username, md5EncryptedPwd)
            println(res)
        }
    }
}