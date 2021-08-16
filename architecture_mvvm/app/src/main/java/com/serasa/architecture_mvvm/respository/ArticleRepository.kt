package com.serasa.architecture_mvvm.respository

import com.serasa.architecture_mvvm.model.Article
import com.serasa.architecture_mvvm.services.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ArticleRepository {

    private val service = RetrofitBuilder.getArticleService()

    fun getArticle(callBack : (List<Article>?, String?) -> Unit)  {

        val call = service.getArticle()
        call.clone().enqueue(object : Callback<List<Article>> {
            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                response.body()?.let {
                    callBack(it, null)
                    callBack(null, "Success!!")
                }
                if (response.code() != 200) {
                    callBack(null, "Algum erro desconhecido!")
                }
            }

            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                callBack(null, t.localizedMessage)
            }

        })
    }
}