package com.serasa.pokemon_mvvm.services


object GetApi {

    fun getPokeApiService() : PokeService{
        return RetrofitBuilder
            .getRetrofitInstance("https://pokeapi.co")
            .create(PokeService::class.java)
    }
}