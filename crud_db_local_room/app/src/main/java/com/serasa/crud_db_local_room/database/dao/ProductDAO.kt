package com.serasa.crud_db_local_room.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.serasa.crud_db_local_room.model.Category
import com.serasa.crud_db_local_room.model.Product
import com.serasa.crud_db_local_room.model.ProductWithCategory
import java.lang.Appendable

@Dao
interface ProductDAO {

    @Transaction
    @Query("SELECT * FROM Product")
    fun getProducts(): List<ProductWithCategory>

    @Insert
    fun insert(product: Product)

    @Insert
    fun insert(category: Category): Long

    fun insert(productWithCategory: ProductWithCategory) {
        insert(productWithCategory.category!!)
        productWithCategory.product?.let { prod ->
            insert(prod)
        }
    }
}