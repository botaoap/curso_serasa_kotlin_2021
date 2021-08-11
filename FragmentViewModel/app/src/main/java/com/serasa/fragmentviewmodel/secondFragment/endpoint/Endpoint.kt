package com.serasa.fragmentviewmodel.secondFragment.endpoint

import com.serasa.fragmentviewmodel.secondFragment.model.Products
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("/products")
    fun getAllProduct(): Call<List<Products>>

}