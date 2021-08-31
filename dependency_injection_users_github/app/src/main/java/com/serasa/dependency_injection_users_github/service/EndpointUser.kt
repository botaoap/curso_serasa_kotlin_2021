package com.serasa.dependency_injection_users_github.service

import com.serasa.dependency_injection_users_github.model.User
import retrofit2.Call
import retrofit2.http.GET

interface EndpointUser {

    @GET("/users")
    fun fetchUsers(): Call<List<User>>
}