package com.serasa.pokemon_mvvm.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.serasa.pokemon_mvvm.model.Types

class Converters {

    @TypeConverter
    fun listoToJason(value: List<Types>?)= Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Types>::class.java).toList()
}