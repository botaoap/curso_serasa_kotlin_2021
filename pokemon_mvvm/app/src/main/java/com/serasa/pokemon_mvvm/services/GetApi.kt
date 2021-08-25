package com.serasa.pokemon_mvvm.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object GetApi {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getPokeApiService(): PokeService = retrofit.create(PokeService::class.java)
}