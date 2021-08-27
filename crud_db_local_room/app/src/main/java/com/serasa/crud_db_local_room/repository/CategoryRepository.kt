package com.serasa.crud_db_local_room.repository

import android.content.Context
import com.serasa.crud_db_local_room.database.AppDatabase
import com.serasa.crud_db_local_room.model.Category

class CategoryRepository (
    context: Context
) {

    private val database = AppDatabase.getDatabase(context)

    fun getAllCategories() : List<Category>{
       return database.categoryDAO().getCategories()
    }

    fun insertIntoDB(category: Category) {
        database.categoryDAO().insertCategory(category)
    }

    fun deleteIntoDB(category: Category) {
        database.categoryDAO().deleteCategory(category)
    }

    fun updateIntoDB(category: String, idCategory: Long) {
        database.categoryDAO().updateCategory(category, idCategory)
    }
}