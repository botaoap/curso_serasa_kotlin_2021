package com.serasa.dependency_injection_users_github.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val connectionToAPI = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getEndpointUser():  EndpointUser{
        return connectionToAPI.create(EndpointUser::class.java)
    }
}