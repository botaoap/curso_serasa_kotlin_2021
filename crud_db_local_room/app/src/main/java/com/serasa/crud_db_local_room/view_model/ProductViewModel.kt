package com.serasa.crud_db_local_room.view_model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serasa.crud_db_local_room.model.Category
import com.serasa.crud_db_local_room.model.Product
import com.serasa.crud_db_local_room.model.ProductWithCategory
import com.serasa.crud_db_local_room.repository.CategoryRepository
import com.serasa.crud_db_local_room.repository.ProductRepository

class ProductViewModel : ViewModel() {

    private val _product = MutableLiveData<List<ProductWithCategory>>()
    var product: LiveData<List<ProductWithCategory>> = _product

    private val _category = MutableLiveData<List<Category>>()
    var category: LiveData<List<Category>> = _category

    private val _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    private lateinit var repositoryProduct: ProductRepository
    private lateinit var repositoryCategory: CategoryRepository

    fun getProducts(context: Context) {
        repositoryProduct = ProductRepository(context)
        _product.value = repositoryProduct.getAllProducts()
    }

    fun getCategory(context: Context) : List<Category>{
        repositoryCategory = CategoryRepository(context)
        return repositoryCategory.getAllCategories()
    }

    fun insertIntoDBProduct(name: String, price: Double, categoryFK: Long, context: Context) {
        repositoryProduct = ProductRepository(context)
        repositoryProduct.insertIntoDBProduct(Product(name = name,price = price,categoryFk = categoryFK))
        getProducts(context)
    }

    fun deleteIntoDBProduct(product: ProductWithCategory, context: Context) {
        repositoryProduct = ProductRepository(context)
        repositoryProduct.deleteIntoDBProduct(product)
        getProducts(context)
    }

    fun updateIntoDBProduct(name: String, price: Double, idProduct: Long, context: Context) {
        repositoryProduct = ProductRepository(context)
        repositoryProduct.updateIntoDBProduct(name, price, idProduct)
        getProducts(context)
    }
}