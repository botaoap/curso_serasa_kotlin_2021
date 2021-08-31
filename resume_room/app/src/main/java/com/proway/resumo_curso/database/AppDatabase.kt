package com.proway.resumo_curso.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.proway.resumo_curso.database.dao.GitHubDAO
import com.proway.resumo_curso.model.GithubModel
import com.proway.resumo_curso.model.GithubOwner

@Database(
    entities = [
        GithubModel::class,
        GithubOwner::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getGithubDao(): GitHubDAO

    companion object {

        /**
         * Singleton que irá gerar nossa classe AppDatabse com tudo implementado pelo Room.
         */
        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "github_app_db"
            )
                .allowMainThreadQueries()
                .build()
        }
    }

}