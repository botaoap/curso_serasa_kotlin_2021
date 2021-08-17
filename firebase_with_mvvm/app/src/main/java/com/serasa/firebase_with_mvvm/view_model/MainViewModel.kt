package com.serasa.firebase_with_mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.serasa.firebase_with_mvvm.repository.AuthenticationRepository

class MainViewModel : ViewModel() {

    private val _user = MutableLiveData<FirebaseUser?>()
    var user: LiveData<FirebaseUser?> = _user

    private val repository = AuthenticationRepository()

    fun createNewAccount(email: String, password: String) {
        repository.createAccountWithEmailPassoword(email, password) {
            _user.value = it
        }

    }
}