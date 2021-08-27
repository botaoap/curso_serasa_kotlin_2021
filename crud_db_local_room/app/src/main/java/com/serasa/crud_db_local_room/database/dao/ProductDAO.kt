package com.serasa.crud_db_local_room.database.dao

import androidx.room.*
import com.serasa.crud_db_local_room.model.Category
import com.serasa.crud_db_local_room.model.Product
import com.serasa.crud_db_local_room.model.ProductWithCategory

@Dao
interface ProductDAO {

    @Transaction
    @Query("SELECT * FROM Product")
    fun getProducts(): List<ProductWithCategory>

    @Insert
    fun insertProduct(product: Product)

    @Insert
    fun insert(category: Category): Long

    fun insert(productWithCategory: ProductWithCategory) {
        insert(productWithCategory.category!!)
        productWithCategory.product?.let { prod ->
            insertProduct(prod)
        }
    }

    @Delete
    fun delete(prod: Product)

    fun deleteProduct(productWithCategory: ProductWithCategory) {
        delete(productWithCategory.product!!)
    }

    @Query("UPDATE Product SET prod_name = :nameProduct, prod_price = :priceProduct WHERE prod_id = :idProduct")
    fun updateProduct(nameProduct: String, priceProduct: Double, idProduct: Long)
}