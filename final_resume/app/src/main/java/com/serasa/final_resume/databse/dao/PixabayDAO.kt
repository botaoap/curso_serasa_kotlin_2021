package com.serasa.final_resume.databse.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.serasa.final_resume.model.Image

@Dao
interface PixabayDAO {

    @Insert(onConflict = REPLACE)
    suspend fun insert(list: List<Image>)

    @Query("SELECT * FROM Image")
    suspend fun fetchImage(): List<Image>

}