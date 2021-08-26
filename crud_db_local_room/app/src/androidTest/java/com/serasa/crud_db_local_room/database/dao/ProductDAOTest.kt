package com.serasa.crud_db_local_room.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth
import com.serasa.crud_db_local_room.database.AppDatabase
import com.serasa.crud_db_local_room.model.Category
import com.serasa.crud_db_local_room.model.Product
import com.serasa.crud_db_local_room.model.ProductWithCategory
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class ProductDAOTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: ProductDAO

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.productDAO()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insert_category_returns_true() {
        val c1 = Category(id = 1L,name = "Eletronico")
        val p1 = Product(id = 2L,name = "TV", price = 100.00, categoryFk = c1.id)
        val productWithCategory = ProductWithCategory(product = p1, category = c1)

        dao.insert(productWithCategory)

        val result = dao.getProducts()
        Truth.assertThat(result).contains(productWithCategory)

    }
}