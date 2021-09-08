package com.serasa.coroutines_thread.service

import com.serasa.coroutines_thread.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface Endpoint {

    @GET("/users")
    suspend fun getUsers(): Response<List<User>>
}