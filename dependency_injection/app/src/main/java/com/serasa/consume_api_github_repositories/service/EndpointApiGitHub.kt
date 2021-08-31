package com.serasa.consume_api_github_repositories.service

import com.serasa.consume_api_github_repositories.model.ItemsGitHub
import com.serasa.consume_api_github_repositories.model.PullRequest
import com.serasa.consume_api_github_repositories.model.RepositoryGitHub
import com.serasa.consume_api_github_repositories.model.UserDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndpointApiGitHub {

    @GET("/search/repositories")
    fun searchRepositories(
        @Query("q") language: String,
        @Query ("sort") sort: String,
        @Query("page") page: Int,
        @Query ("order") order: String,
    ) : Call<RepositoryGitHub>

    @GET("/repos/{owner}/{repo}/pulls")
    fun getPullRequestRepository(
        @Path ("owner") owner: String,
        @Path ("repo") repo: String,

    ) : Call<List<PullRequest>>

    @GET("/users/{username}")
    fun getUserDetail(
        @Path("username") username: String
    ) : Call<UserDetail>
}