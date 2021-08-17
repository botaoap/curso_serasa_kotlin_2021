package com.serasa.firebase_with_mvvm.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.security.auth.callback.Callback


class AuthenticationRepository {

    private val auth = FirebaseAuth.getInstance()

//    fun authenticationWithEmailPassword(email: String, password: String) {
//
//    }

    fun createAccountWithEmailPassoword(
        email: String,
        password: String,
        callback: (FirebaseUser?) -> Unit
    ) {
        val task = auth.createUserWithEmailAndPassword(email, password)
        task.addOnSuccessListener { authResult ->
            callback(authResult.user)
        }
    }
}