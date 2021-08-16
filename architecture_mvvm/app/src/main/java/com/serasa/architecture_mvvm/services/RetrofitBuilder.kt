package com.serasa.architecture_mvvm.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofitArticle = Retrofit.Builder()
        .baseUrl("https://api.spaceflightnewsapi.net")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getArticleService() : ArticleService {
        return retrofitArticle.create(ArticleService::class.java)
    }
}