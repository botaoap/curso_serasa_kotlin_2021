package com.serasa.consume_api_github_repositories.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serasa.consume_api_github_repositories.model.ItemsGitHub
import com.serasa.consume_api_github_repositories.repository.RepositoryGitHubRepository

class SearchRepositoriesViewModel : ViewModel() {

    private val _repository = MutableLiveData<List<ItemsGitHub>>()
    var repository: LiveData<List<ItemsGitHub>> = _repository

    private val _page = MutableLiveData(0)
    var page: LiveData<Int> = _page

    private val _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    private val repositoryGitHub = RepositoryGitHubRepository()

    fun getSearchRepository(language: String, page: Int = 1) {
        repositoryGitHub.fetchAllRepositories(language = language, page = page) { listRepo, error ->
            listRepo?.apply {
                _repository.value = this.items
            }
            error?.apply {
                _error.value = error
            }
        }
    }

    fun nextPage() {
        _page.value = _page.value!! + 1
    }
}