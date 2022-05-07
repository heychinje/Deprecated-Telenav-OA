package com.telenav.oa.di

import com.telenav.oa.domain.repository.UserRepository
import com.telenav.oa.domain.repository.impl.UserRepositoryImpl
import com.telenav.oa.domain.repository.remote.RemoteServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @WorkDispatcher
    @Provides
    @Singleton
    fun provideWorkDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IODispatcher
    @Provides
    @Singleton
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @UIDispatcher
    @Provides
    @Singleton
    fun provideUIDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().apply {}.build()

    @Provides
    @Singleton
    fun provideRetrofitClient(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder().apply {
        baseUrl(RemoteServiceApi.BASE_URL)
        client(okHttpClient)
        addConverterFactory(GsonConverterFactory.create())
    }.build()

    @Provides
    @Singleton
    fun provideRemoteServiceApi(
        retrofit: Retrofit
    ): RemoteServiceApi = retrofit.create(RemoteServiceApi::class.java)

    @Provides
    @Singleton
    fun provideUserRepository(
        remoteServiceApi: RemoteServiceApi
    ): UserRepository = UserRepositoryImpl(remoteServiceApi)
}