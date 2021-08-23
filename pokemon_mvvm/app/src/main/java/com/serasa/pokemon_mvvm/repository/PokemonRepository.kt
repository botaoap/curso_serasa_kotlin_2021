package com.serasa.pokemon_mvvm.repository

import android.content.Context
import com.serasa.pokemon_mvvm.database.AppDataBase
import com.serasa.pokemon_mvvm.model.Pokemon
import com.serasa.pokemon_mvvm.model.ResultListPokemon
import com.serasa.pokemon_mvvm.services.GetApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PokemonRepository(private val context: Context) {

    private val dataBase = AppDataBase.getDataBase(context)

    fun fetchAll(onComplete: (ResultListPokemon?, String?) -> Unit) {
        GetApi.getPokeApiService()
            .getPokemonAll()
            .enqueue(object : Callback<ResultListPokemon> {
                override fun onResponse(
                    call: Call<ResultListPokemon>,
                    response: Response<ResultListPokemon>
                ) {
                    if (response.body() != null) {
                        onComplete(response.body(), null)
                    } else {
                        onComplete(null, "Nenhum pokemon encontrado")
                    }
                }

                override fun onFailure(call: Call<ResultListPokemon>, t: Throwable) {
                    onComplete(null, t.message)
                }

            })
    }

    fun insertIntoDataBase(item: List<Pokemon>) {
        val dao = dataBase.pokemonDAO()
        item.forEach { poke ->
            dao.insert(pokemon = poke)
        }
    }

    fun fetchAllFromDataBase(): List<Pokemon> {
        val dao = dataBase.pokemonDAO()
        return dao.all()
    }
}