package com.serasa.firebase_unit_testing.service

import com.serasa.firebase_unit_testing.model.GitUserModel
import retrofit2.Response
import retrofit2.http.GET

interface GithubAPI {

    @GET("/users")
    suspend fun fetchUsers(
    ): Response<List<GitUserModel>>

}