package com.serasa.pokemon_mvvm.database

import android.content.Context
import androidx.room.*
import com.serasa.pokemon_mvvm.database.dao.PokemonDAO
import com.serasa.pokemon_mvvm.model.*

@Database(
    entities = [
        Pokemon::class, PokemonDetails::class, Sprites::class, Other::class, ArtWork::class,
        Types::class, PokemonType::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun pokemonDAO(): PokemonDAO

    companion object {

        fun getDataBase(context: Context): AppDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "pokemon_app_db"
            )
                .allowMainThreadQueries()
                .build()
        }


//        @Volatile
//        private var INSTANCE: AppDataBase? = null
//
//        fun getDataBase(context: Context): AppDataBase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDataBase::class.java,
//                    "pokemon_app_db"
//                )
//                    .allowMainThreadQueries()
//                    .build()
//                INSTANCE = instance
////                return instance
//                instance
//            }
    }
}