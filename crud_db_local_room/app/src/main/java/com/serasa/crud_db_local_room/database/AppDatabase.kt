package com.serasa.crud_db_local_room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.serasa.crud_db_local_room.database.dao.CategoryDAO
import com.serasa.crud_db_local_room.database.dao.ProductDAO
import com.serasa.crud_db_local_room.model.Category
import com.serasa.crud_db_local_room.model.Product


@Database(
    entities = [Product::class, Category::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDAO(): CategoryDAO
    abstract fun productDAO(): ProductDAO

    companion object {

        /**
         * Singleton que irá gerar nossa classe AppDatabse com tudo implementado pelo Room.
         */
        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "crud_app_db"
            )
                .allowMainThreadQueries() // Utilizar esta linha quando NÃO utilizar coroutines
                .build()
        }
    }

}