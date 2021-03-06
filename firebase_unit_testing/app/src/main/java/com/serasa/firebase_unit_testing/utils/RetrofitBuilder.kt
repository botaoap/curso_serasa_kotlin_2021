package com.serasa.firebase_unit_testing.utils

import com.serasa.firebase_unit_testing.service.GithubAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * Retorna a interface GithubServices implementada pelo retrofit.
     */
    fun getGithubServices(): GithubAPI = retrofit.create(GithubAPI::class.java)
}