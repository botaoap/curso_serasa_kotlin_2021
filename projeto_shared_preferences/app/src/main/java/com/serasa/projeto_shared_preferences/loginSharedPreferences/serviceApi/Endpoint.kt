package com.serasa.projeto_shared_preferences.loginSharedPreferences.serviceApi

import com.serasa.projeto_shared_preferences.loginSharedPreferences.model.User
import retrofit.Call
import retrofit.http.GET

interface Endpoint {
    @GET("/users/1")
    fun getOneUser(): Call<User>
}