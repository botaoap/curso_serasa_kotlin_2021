package com.serasa.architecture_mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serasa.architecture_mvvm.model.Article
import com.serasa.architecture_mvvm.respository.ArticleRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel(), Callback<List<Article>> {

    private val _article = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _article

    private val repository = ArticleRepository()

    fun fetchArticle() {
        repository.getArticle(this)
    }

    override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
        response.body()?.apply {
            _article.value = this
        }
    }

    override fun onFailure(call: Call<List<Article>>, t: Throwable) {

    }
}