package com.serasa.pokemon_mvvm.services

import com.google.gson.annotations.SerializedName
import com.serasa.pokemon_mvvm.model.Pokemon
import com.serasa.pokemon_mvvm.model.ResultListPokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeService {

    @GET("/api/v2/pokemon")
    fun getPokemonAll(): Call<ResultListPokemon>

    @GET("/api/v2/pokemon/{id}")
    fun getPokemonId(@Path("id") id: String): Call<Pokemon>



}