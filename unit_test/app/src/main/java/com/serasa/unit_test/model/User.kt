package com.serasa.unit_test.model

import android.text.TextUtils
import android.util.Patterns

data class User(
    val email: String,
    val name: String,
    val password: String,
    val cofirmPassword: String
) {
    fun validateUser(): Boolean {
        if (!email.contains('@')) {
            return false
        }
        if (email.isEmpty()) {
            return false
        }
        if (password.length < 6 || password != cofirmPassword) {
            return false
        }
        if (name.length <= 1) {
            return false
        }
        return true
    }
}
