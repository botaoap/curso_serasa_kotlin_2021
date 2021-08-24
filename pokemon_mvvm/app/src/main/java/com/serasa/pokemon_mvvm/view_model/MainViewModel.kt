package com.serasa.pokemon_mvvm.view_model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serasa.pokemon_mvvm.model.Pokemon
import com.serasa.pokemon_mvvm.repository.PokemonRepository

class MainViewModel : ViewModel() {

    private val _pokeResponse = MutableLiveData<List<Pokemon>>()
    var pokeResponse: LiveData<List<Pokemon>> = _pokeResponse

    private val _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

//    private val pokemonRepository = PokemonRepository()

    private fun fetchAllFromServer(context: Context) {
        val repository = PokemonRepository(context)
        repository.fetchAll { response, error ->
            response?.let {
                _pokeResponse.value = it.results
                loadDetails(it.results, repository)
            }
            error?.let {
                _error.value = it
            }
        }
    }

    private fun loadDetails(pokemon: List<Pokemon>, repository: PokemonRepository) {
        pokemon.forEach { poke ->
            repository.fetchPokemonDetail(pokeId = poke.extracIfFromUrl()) { detail, _ ->
                detail.let {
                    poke.details = detail
                    repository.insertIntoDataBase(poke)
                }
            }
        }
    }

    fun fetchAllFromDataBase(context: Context) {
        val listOf = PokemonRepository(context).fetchAllFromDataBase()
        if (listOf != null && listOf.isNotEmpty()) {
            _pokeResponse.value = listOf
        } else {
            fetchAllFromServer(context)
        }
    }
}