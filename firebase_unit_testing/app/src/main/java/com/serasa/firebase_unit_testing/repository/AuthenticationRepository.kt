package com.serasa.firebase_unit_testing.repository

import com.google.firebase.auth.FirebaseAuth
import com.serasa.firebase_unit_testing.repository.interfaces.ISignInResult

class AuthenticationRepository(private val observer: ISignInResult,
                               private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()) {

    fun signIn(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).apply {
            if (this.isSuccessful) observer.success(email, password)
            else observer.failure(email, password)
        }
    }
}