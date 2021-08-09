package com.serasa.login_serasa.loginConsumindoApiWithToken.endpoint


import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Auth
import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Credentials
import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Products
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceUser {

    @GET("/products")
    fun getAllProdutc(): Call<List<Products>>

    @POST("/auth/login")
    fun login(@Body credentials: Credentials): Call<Auth>
}