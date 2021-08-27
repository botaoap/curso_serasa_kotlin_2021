package com.serasa.crud_db_local_room.view_model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serasa.crud_db_local_room.model.Category
import com.serasa.crud_db_local_room.repository.CategoryRepository

class CategoryViewModel : ViewModel() {

    private val _category = MutableLiveData<List<Category>>()
    var category: LiveData<List<Category>> = _category

    private val _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    private lateinit var categoryRepository: CategoryRepository

    fun getCategories(context: Context) {
        categoryRepository = CategoryRepository(context)
        _category.value = categoryRepository.getAllCategories()
    }

    fun insertIntopDB(category: String, context: Context) {
        categoryRepository = CategoryRepository(context)
        categoryRepository.insertIntoDB(Category(name = category))
        getCategories(context)

    }

    fun deleteIntoDB(category: Category,context: Context) {
        categoryRepository = CategoryRepository(context)
        categoryRepository.deleteIntoDB(category)
        getCategories(context)

    }
}