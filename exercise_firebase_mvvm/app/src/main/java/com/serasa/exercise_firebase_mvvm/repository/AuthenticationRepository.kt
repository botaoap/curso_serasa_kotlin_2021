package com.serasa.exercise_firebase_mvvm.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthenticationRepository {

    /**
     * Authenticantion Login With Firebase
     */

    private val auth = FirebaseAuth.getInstance()

    fun signInWithEmailPassword(
        email: String,
        password: String,
        callback: (FirebaseUser?, String?) -> Unit
    ) {
        val task = auth.signInWithEmailAndPassword(email,password)
        task.addOnSuccessListener { authResult ->
            authResult.user?.let {
                if (authResult != null) {
                    callback(authResult.user, null)
                } else {
                    callback(null, "Erro no Login")
                }
            }
        }
        task.addOnFailureListener {
            callback(null, it.message)
        }
    }

    fun createAccountWithEmailPassword(
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