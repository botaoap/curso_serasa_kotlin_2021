package com.serasa.pokemon_mvvm.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.serasa.pokemon_mvvm.database.AppDataBase
import com.serasa.pokemon_mvvm.model.Other
import com.serasa.pokemon_mvvm.model.Pokemon
import com.serasa.pokemon_mvvm.model.PokemonDetails
import com.serasa.pokemon_mvvm.model.Sprites
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class PokemonDAOTest {

    private lateinit var database: AppDataBase
    private lateinit var dao: PokemonDAO

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDataBase::class.java
        ).allowMainThreadQueries().build()
        dao = database.pokemonDAO()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun test_insert_into_data_base_need_return_true() {
        val pokemonToInsert =
            Pokemon("pikachu", "", PokemonDetails(0, Sprites(0, Other(0, null)), emptyList()))

        dao.insert(pokemonToInsert)

        val returnedPokemons = dao.all()
        assertThat(returnedPokemons).contains(pokemonToInsert)
    }

    @Test
    fun test_select_like() {
        val pokemon1 =
            Pokemon("botao", "", PokemonDetails(0, Sprites(0, Other(0, null)), emptyList()))
        dao.insert(pokemon1)
        val pokemon2 =
            Pokemon("helo", "", PokemonDetails(0, Sprites(0, Other(0, null)), emptyList()))
        dao.insert(pokemon2)
        val pokemon3 =
            Pokemon("arthur", "", PokemonDetails(0, Sprites(0, Other(0, null)), emptyList()))
        dao.insert(pokemon3)

        val returnedPokemons = dao.fetchFiltered("ao")
        assertThat(returnedPokemons).hasSize(1)
    }

    @Test
    fun test_fetch_by_id() {
        val pokemon1 =
            Pokemon("botao", "", PokemonDetails(0, Sprites(0, Other(0, null)), emptyList()))
        dao.insert(pokemon1)
        val pokemon2 =
            Pokemon("helo", "", PokemonDetails(0, Sprites(0, Other(0, null)), emptyList()))
        dao.insert(pokemon2)
        val pokemon3 =
            Pokemon("arthur", "", PokemonDetails(0, Sprites(0, Other(0, null)), emptyList()))
        dao.insert(pokemon3)

        val pokemonById = dao.byId("arthur")
        assertThat(pokemonById).isEqualTo(pokemon3)

    }
}