package com.serasa.pokemon_mvvm.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.serasa.pokemon_mvvm.model.Pokemon

@Dao
interface PokemonDAO {

    @Query("SELECT * FROM Pokemon ORDER BY poke_name")
    fun all() : List<Pokemon>

    @Query("SELECT * FROM Pokemon WHERE poke_name = :pokeId")
    fun byId(pokeId: String) : List<Pokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemon: Pokemon)
}