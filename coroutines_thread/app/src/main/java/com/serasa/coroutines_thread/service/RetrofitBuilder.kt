package com.serasa.coroutines_thread.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofitConnection = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getConnection(): Endpoint {
        return retrofitConnection.create(Endpoint::class.java)
    }

}