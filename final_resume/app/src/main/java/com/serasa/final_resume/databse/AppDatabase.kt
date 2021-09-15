package com.serasa.final_resume.databse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
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
}