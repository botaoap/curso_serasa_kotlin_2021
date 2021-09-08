package com.serasa.coroutines_thread.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serasa.coroutines_thread.model.User
import com.serasa.coroutines_thread.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {

    private val _user = MutableLiveData<List<User>>()
    var user: LiveData<List<User>> = _user

    fun fetchUser() {
        viewModelScope.launch {
            _user.value = repository.getUsers().await()
        }
    }
}