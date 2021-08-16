package com.serasa.architecture_mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serasa.architecture_mvvm.model.Article
import com.serasa.architecture_mvvm.respository.ArticleRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _article = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _article

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val repository = ArticleRepository()

    fun fetchArticle() {
        repository.getArticle { list, error ->
            list?.apply {
                _article.value = this
            }
            error?.apply {
                _error.value = this
            }
        }
    }
}