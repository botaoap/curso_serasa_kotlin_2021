package com.serasa.dependency_injection_users_github.di

import com.serasa.dependency_injection_users_github.repository.UserRepository
import com.serasa.dependency_injection_users_github.service.EndpointUser
import com.serasa.dependency_injection_users_github.service.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideUserService() : EndpointUser = RetrofitBuilder.getEndpointUser()

    @Provides
    fun provideUserRepository(service: EndpointUser) : UserRepository = UserRepository(service)

}