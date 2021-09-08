package com.serasa.coroutines_thread.di

import com.serasa.coroutines_thread.repository.UserRepository
import com.serasa.coroutines_thread.service.Endpoint
import com.serasa.coroutines_thread.service.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class HiltModule {

    @Provides
    fun provideUserService(): Endpoint = RetrofitBuilder.getConnection()

    @Provides
    fun provideUserRepository(service: Endpoint): UserRepository = UserRepository(service)
}