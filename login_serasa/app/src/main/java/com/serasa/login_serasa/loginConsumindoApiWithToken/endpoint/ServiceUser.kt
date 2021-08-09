package com.serasa.login_serasa.loginConsumindoApiWithToken.endpoint


import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Auth
import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Credentials
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceUser {

//    @GET("/users")
//    fun getAll(): Call<List<UserToken>>

    @POST("/auth/login")
    fun login(@Body credentials: Credentials): Call<Auth>
}