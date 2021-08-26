package com.serasa.crud_db_local_room.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.serasa.crud_db_local_room.repository.AuthenticantionRepository

class SignUpViewModel : ViewModel() {

    private val _user = MutableLiveData<FirebaseUser>()
    var user: LiveData<FirebaseUser> = _user

    private var _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    private val authRepository = AuthenticantionRepository()

    fun createAccountWithEmailPassword(email: String, password: String) {
        authRepository.creatAccountWithEmailPassword(email,password) { firebaseUser ->
            if (firebaseUser != null) {
                _user.value = firebaseUser
            }
        }
    }
}