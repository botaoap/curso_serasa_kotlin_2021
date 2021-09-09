package com.serasa.pokemon_mvvm.repository

import android.content.Context
import com.serasa.pokemon_mvvm.database.AppDataBase
import com.serasa.pokemon_mvvm.model.Pokemon
import com.serasa.pokemon_mvvm.model.PokemonDetails
import com.serasa.pokemon_mvvm.model.ResultListPokemon
import com.serasa.pokemon_mvvm.services.GetApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PokemonRepository(private val context: Context) {

    private val dataBase = AppDataBase.getDataBase(context)
    private val service = GetApi.getPokeApiService()

    suspend fun fetchAll(): List<Pokemon>? {
        return withContext(CoroutineScope(Dispatchers.Main).coroutineContext) {
            fetchAllFromDataBase().let { dataFromDb ->
                if (dataFromDb.isNullOrEmpty()) {
                    service.getPokemonAll().let { response ->
                        processData(response).let { responsePokemon ->
                            responsePokemon?.results?.forEach { pokemon ->
                                fetchPokemonDetail(pokemon.extracIfFromUrl()).let { details ->
                                    pokemon.details = details
                                }
                            }
                            responsePokemon?.results?.let {
                                insertIntoDataBase(it)
                            }
                        }
                    }
                    fetchAllFromDataBase()
                } else {
                    dataFromDb
                }
            }
        }
    }

    private fun <T> processData(response: Response<T>): T? {
        return if (response.isSuccessful) response.body() else null
    }

    private suspend fun fetchPokemonDetail(pokeId: String): PokemonDetails? {
        return withContext(CoroutineScope(Dispatchers.Main).coroutineContext) {
            service.getPokemonId(pokeId).let { response ->
                processData(response)
            }
        }
    }

    fun insertIntoDataBase(item: List<Pokemon>) {
        val dao = dataBase.pokemonDAO()
        item.forEach { poke ->
            dao.insert(pokemon = poke)
        }
    }

    fun insertIntoDataBase(pokemon: Pokemon) {
        val dao = dataBase.pokemonDAO()
        dao.insert(pokemon = pokemon)
    }

    fun fetchAllFromDataBase(): List<Pokemon> {
        val dao = dataBase.pokemonDAO()
        return dao.all()
    }

    fun fetchAllFromDataBaseWithFilter(query : String): List<Pokemon> {
        val dao = dataBase.pokemonDAO()
        return dao.fetchFiltered(query)
    }
}