package com.serasa.pokemon_mvvm.view_model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serasa.pokemon_mvvm.model.Pokemon
import com.serasa.pokemon_mvvm.repository.PokemonRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _pokeResponse = MutableLiveData<List<Pokemon>>()
    var pokeResponse: LiveData<List<Pokemon>> = _pokeResponse

    private val _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    private val _loading = MutableLiveData<Boolean>()
    var loading: LiveData<Boolean> = _loading

    fun fetchAllFromServer(context: Context) {
        PokemonRepository(context).let { repository ->
            _loading.value = true
            viewModelScope.launch {
                repository.fetchAll()?.let { pokemon ->
                    _loading.value = false
                    _pokeResponse.value = pokemon
                }
            }
        }
    }

    fun fetchAllFromDataBase(context: Context) {
        PokemonRepository(context).fetchAllFromDataBase().let { listOf ->
            if (listOf != null && listOf.isNotEmpty()) {
                _pokeResponse.value = listOf
            } else {
                fetchAllFromDataBase(context)
            }
        }
    }

    fun fetchFilteredFromDataBase(context: Context, query: String) {
        val repository = PokemonRepository(context)
        _pokeResponse.value = emptyList()
        val filteredList = repository.fetchAllFromDataBaseWithFilter(query)
        filteredList?.let {
            _pokeResponse.value = it
        }
    }
}