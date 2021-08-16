package com.serasa.architecture_mvvm.respository

import com.serasa.architecture_mvvm.model.Article
import com.serasa.architecture_mvvm.services.RetrofitBuilder
import retrofit2.Callback


class ArticleRepository {

    private val service = RetrofitBuilder.getArticleService()

    fun getArticle(callBack : Callback<List<Article>>) {
        val call = service.getArticle()
        call.clone().enqueue(callBack)
    }
}