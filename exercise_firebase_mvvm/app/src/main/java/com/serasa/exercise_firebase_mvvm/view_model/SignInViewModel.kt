package com.serasa.exercise_firebase_mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.serasa.exercise_firebase_mvvm.repository.AuthenticationRepository

class SignInViewModel : ViewModel() {

    private val _user = MutableLiveData<FirebaseUser>()
    var user : LiveData<FirebaseUser> = _user

    private val _error = MutableLiveData<String>()
    var error : LiveData<String> = _error

    private val authRepository = AuthenticationRepository()

    fun signIn(email: String, password: String) {
        authRepository.signInWithEmailPassword(email, password) { firebaseUser, error ->
            if (firebaseUser != null) {
                _user.value = firebaseUser
            } else {
                _error.value = error ?: "Erro desconhecido"
            }
        }
    }
}