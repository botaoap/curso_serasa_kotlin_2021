package com.serasa.pokemon_mvvm.services

import com.serasa.pokemon_mvvm.model.PokemonDetails
import com.serasa.pokemon_mvvm.model.ResultListPokemon
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeService {

    @GET("/api/v2/pokemon?limit=1118")
    suspend fun getPokemonAll(): Response<ResultListPokemon>

    @GET("/api/v2/pokemon/{id}")
    suspend fun getPokemonId(@Path("id") id: String): Response<PokemonDetails>

}