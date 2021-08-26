package com.serasa.crud_db_local_room.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Root
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.serasa.crud_db_local_room.database.AppDatabase
import com.serasa.crud_db_local_room.model.Category
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class CategoryDAOTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: CategoryDAO

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
        dao = database.categoryDAO()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insert_category_returns_true() {
        val category1 = Category(name = "Eletronico")
        val category2 = Category(name = "Higiene")
        val category3 = Category(name = "Bazar")
        val listOfInsert = arrayListOf(category1, category2, category3)
        dao.insert(listOfInsert)

        val result = dao.getCategories()
        assertThat(result).hasSize(3)

    }


}