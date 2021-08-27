package com.serasa.crud_db_local_room.database.dao

import androidx.room.*
import com.serasa.crud_db_local_room.model.Category

@Dao
interface CategoryDAO {

    @Query("SELECT * FROM Category")
    fun getCategories() : List<Category>

    @Insert
    fun insert(list: List<Category>)

    @Insert
    fun insertCategory(list: Category)

    @Delete
    fun deleteCategory(list: Category)

    @Query("UPDATE Category SET cat_name = :nameUpdate WHERE cat_id = :idCategory")
    fun updateCategory(nameUpdate: String, idCategory: Long)

}