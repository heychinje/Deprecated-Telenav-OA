package com.telenav.oa.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject

class Md5UseCase @Inject constructor(
    private val workDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(input: ByteArray) = withContext(workDispatcher) {
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(input)
        BigInteger(1, digest).toString(16).padStart(32)
    }
}