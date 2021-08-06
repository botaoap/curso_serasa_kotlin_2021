package com.serasa.login_serasa.loginConsumindoApi.serviceApi

import com.serasa.login_serasa.loginConsumindoApi.model.User
import retrofit2.Call
import retrofit2.http.GET

interface EndpointUser {

    @GET("/users")
    fun getUsers() : Call<List<User>>
}