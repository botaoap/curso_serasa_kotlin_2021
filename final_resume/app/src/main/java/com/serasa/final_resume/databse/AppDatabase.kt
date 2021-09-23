package com.serasa.final_resume.databse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.serasa.final_resume.databse.dao.PixabayDAO
import com.serasa.final_resume.model.Image

@Database(
    entities = [
        Image::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){

    abstract fun getPixabayDao(): PixabayDAO

    companion object {
        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "final_resume_db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    private val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
        }
    }

    private val MIGRATION_2_3 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
        }
    }

    private val MIGRATION_3_4 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
        }
    }
}