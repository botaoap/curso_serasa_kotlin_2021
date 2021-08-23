package com.serasa.pokemon_mvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.serasa.pokemon_mvvm.database.dao.PokemonDAO
import com.serasa.pokemon_mvvm.model.Pokemon

@Database(entities = [Pokemon::class], version = 1)
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