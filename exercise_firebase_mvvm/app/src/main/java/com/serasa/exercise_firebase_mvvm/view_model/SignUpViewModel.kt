package com.serasa.exercise_firebase_mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.serasa.exercise_firebase_mvvm.repository.AuthenticationRepository

class SignUpViewModel : ViewModel() {

    private val _user = MutableLiveData<FirebaseUser?>()
    var user : LiveData<FirebaseUser?> = _user

    private val _error = MutableLiveData<String?>()
    var error : LiveData<String?> = _error

    private val authRespository = AuthenticationRepository()

    fun createNewAccount(email: String, password: String) {
        authRespository.createAccountWithEmailPassword(email,password) {
            _user.value = it
        }

    }
}