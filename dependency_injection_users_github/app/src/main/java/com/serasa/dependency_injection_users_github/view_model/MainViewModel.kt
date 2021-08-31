package com.serasa.dependency_injection_users_github.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serasa.dependency_injection_users_github.model.User
import com.serasa.dependency_injection_users_github.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val respository: UserRepository
): ViewModel() {

    private val _user = MutableLiveData<List<User>>()
    var user: LiveData<List<User>> = _user

    private val _page = MutableLiveData(0)
    var page: LiveData<Int> = _page

    private val _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    fun fetchUser() {
        respository.fetchUsers() { user, error ->
            user?.let {
                _user.value = user
            }
            error?.let {
                _error.value = error
            }
        }
    }

    fun nextPage() {
        _page.value = _page.value!! + 1
    }
}