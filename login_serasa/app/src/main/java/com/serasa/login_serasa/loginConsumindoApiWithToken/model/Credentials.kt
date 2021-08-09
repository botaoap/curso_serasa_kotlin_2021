package com.serasa.login_serasa.loginConsumindoApiWithToken.model

import com.google.gson.annotations.SerializedName

data class Credentials(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
) {

    fun checkUserName(): Boolean {
        return username.isNotEmpty()
    }

    fun checkPassword(): Boolean {
        return password.isNotEmpty()
    }
}