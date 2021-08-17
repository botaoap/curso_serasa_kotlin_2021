package com.serasa.firebase_with_mvvm.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.security.auth.callback.Callback


class AuthenticationRepository {

    private val auth = FirebaseAuth.getInstance()

    fun signInWithEmailPassword(
        email: String,
        password: String,
        callback: (FirebaseUser?, String?) -> Unit
    ) {
        val task = auth.signInWithEmailAndPassword(email, password)
        task.addOnSuccessListener { authResul ->
            authResul.user?.let {
                if (authResul != null) {
                    callback(authResul.user, null)
                }else {
                    callback(null, "Erro no login")
                }
            }
        }
        task.addOnFailureListener{
            callback(null, it.message)
        }
    }

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