package com.serasa.firebase_unit_testing.repository.interfaces

interface ISignInResult {
    fun success(email: String, password: String)
    fun failure(email: String, password: String)
}