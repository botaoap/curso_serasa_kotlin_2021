package com.serasa.pokemon_mvvm.services

import com.serasa.pokemon_mvvm.model.PokemonDetails
import com.serasa.pokemon_mvvm.model.ResultListPokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeService {

    @GET("/api/v2/pokemon?limit=1118")
    fun getPokemonAll(): Call<ResultListPokemon>

    @GET("/api/v2/pokemon/{id}")
    fun getPokemonId(@Path("id") id: String): Call<PokemonDetails>

}