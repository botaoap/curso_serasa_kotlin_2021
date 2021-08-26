package com.serasa.crud_db_local_room.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.serasa.crud_db_local_room.model.Category

@Dao
interface CategoryDAO {

    @Query("SELECT * FROM Category")
    fun getCategories() : List<Category>

    @Insert
    fun insert(list: List<Category>)


}