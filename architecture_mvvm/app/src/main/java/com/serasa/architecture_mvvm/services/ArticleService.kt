package com.serasa.architecture_mvvm.services

import com.serasa.architecture_mvvm.model.Article
import retrofit2.Call
import retrofit2.http.GET

interface ArticleService {
    @GET("/v3/articles")
    fun getArticle() : Call<List<Article>>
}