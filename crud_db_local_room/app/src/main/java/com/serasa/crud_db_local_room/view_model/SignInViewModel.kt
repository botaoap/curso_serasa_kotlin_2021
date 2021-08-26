package com.serasa.crud_db_local_room.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import com.serasa.crud_db_local_room.repository.AuthenticantionRepository

class SignInViewModel : ViewModel() {

    private val _user = MutableLiveData<FirebaseUser>()
    var user: LiveData<FirebaseUser> = _user

    private val _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    private val authRepository = AuthenticantionRepository()

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