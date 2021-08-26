package com.serasa.crud_db_local_room.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import javax.security.auth.callback.Callback

class AuthenticantionRepository {

    private val auth = FirebaseAuth.getInstance()

    fun signInWithEmailPassword(
        email: String,
        password: String,
        callback: (FirebaseUser?, String?) -> Unit
    ) {
        val task = auth.signInWithEmailAndPassword(email, password)
        task.addOnSuccessListener { authResult ->
            authResult.user?.let {
                if (authResult != null) {
                    callback(authResult.user, null)
                } else {
                    callback(null, "Erro Login")
                }
            }
        }
        task.addOnFailureListener {
            callback(null, it.message)
        }
    }

    fun creatAccountWithEmailPassword(
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