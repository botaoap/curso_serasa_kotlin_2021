package com.serasa.login_serasa.loginConsumindoApiWithToken.endpoint


import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Auth
import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Credentials
import com.serasa.login_serasa.loginConsumindoApiWithToken.model.Products
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServiceUser {

    @GET("/products")
    fun getAllProducts(): Call<List<Products>>

    @GET("/products/{id}")
    fun getProductId(@Path ("id") products: Int): Call<Products>

    @POST("/auth/login")
    fun login(@Body credentials: Credentials): Call<Auth>
}