package com.proway.resumo_curso.di

import android.content.Context
import com.proway.resumo_curso.database.AppDatabase
import com.proway.resumo_curso.database.dao.GitHubDAO
import com.proway.resumo_curso.repository.GithubRepository
import com.proway.resumo_curso.service.GithubServices
import com.proway.resumo_curso.service.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideGitHubRepository(
        dao: GitHubDAO,
        services: GithubServices
    ) : GithubRepository = GithubRepository(dao, services)

    @Provides
    fun provideGitHubServices(): GithubServices = RetrofitService.getGithubServices()

    @Provides
    fun provideGitHubDao(@ApplicationContext context: Context): GitHubDAO {
        return AppDatabase.getDatabase(context).getGithubDao()
    }
}