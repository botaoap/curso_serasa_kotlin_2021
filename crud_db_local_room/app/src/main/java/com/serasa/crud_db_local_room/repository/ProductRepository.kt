package com.serasa.crud_db_local_room.repository

import android.content.Context
import com.serasa.crud_db_local_room.database.AppDatabase
import com.serasa.crud_db_local_room.model.Product
import com.serasa.crud_db_local_room.model.ProductWithCategory

class ProductRepository(
    context: Context
) {
    private val database = AppDatabase.getDatabase(context)

    fun getAllProducts() : List<ProductWithCategory> {
        return database.productDAO().getProducts()
    }

    fun insertIntoDBProduct(product: Product) {
        database.productDAO().insertProduct(product)
    }

    fun deleteIntoDBProduct(product: ProductWithCategory) {
        database.productDAO().deleteProduct(product)
    }

    fun updateIntoDBProduct(name: String, price: Double, idProduct: Long) {
        database.productDAO().updateProduct(name, price, idProduct)
    }

}